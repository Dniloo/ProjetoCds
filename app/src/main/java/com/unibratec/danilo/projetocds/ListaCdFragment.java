package com.unibratec.danilo.projetocds;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.unibratec.danilo.projetocds.model.Cd;
import com.unibratec.danilo.projetocds.model.Genero;
import com.unibratec.danilo.projetocds.model.Discoteca;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListaCdFragment extends Fragment {

    @Bind(R.id.list_cd)
    ListView mListView;
    @Bind(R.id.swipe)
    SwipeRefreshLayout mSwipe;

    List<Cd> mCds;

    ArrayAdapter<Cd> mAdapter;
    CdsTask mTask;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setReenterTransition(true);
        mCds = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_lista_cd, container, false);
        ButterKnife.bind(this, layout);

        mAdapter = new CdsAdapter(getContext(), mCds);
        mListView.setAdapter(mAdapter);

        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTask = new CdsTask();
                mTask.execute();
            }
        });
        return  layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mCds.size() == 0 && mTask == null) {
            mTask = new CdsTask();
            mTask.execute();
        } else if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING){
            mSwipe.setRefreshing(true);
        }
    }

    private void showProgress(){
        mSwipe.post(new Runnable() {
            @Override
            public void run() {
                mSwipe.setRefreshing(true);
            }
        });
    }

    @OnItemClick(R.id.list_cd)
        void onItemSelected(int position){
        Cd cd = mCds.get(position);
        if (getActivity() instanceof CliqueNoCdListener){
            CliqueNoCdListener listener = (CliqueNoCdListener)getActivity();
            listener.cdFoiClicado(cd);
        }
    }

    public interface CliqueNoCdListener{
        void cdFoiClicado(Cd cd);
    }

    class CdsTask extends AsyncTask<Void, Void, Discoteca>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            showProgress();
        }

        @Override
        protected Discoteca doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://dl.dropboxusercontent.com/s/n5qbyvner44nhkr/Discoteca.json")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String jsonString = response.body().string();
                    Log.d("NGVL", jsonString);
                    Gson gson = new Gson();
                    Discoteca discoteca = gson.fromJson(jsonString, Discoteca.class);
                    return discoteca;

                } catch (Exception e){
                    e.printStackTrace();
                }

            return null;
        }

        @Override
        protected void onPostExecute(Discoteca discoteca) {
            super.onPostExecute(discoteca);

            if(discoteca != null){
                mCds.clear();
                for (Genero genero : discoteca.getGeneros()){
                    mCds.addAll(genero.getCds());
                }
                mAdapter.notifyDataSetChanged();
            }
            mSwipe.setRefreshing(false);
        }
    }
}
