package com.unibratec.danilo.projetocds;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.unibratec.danilo.projetocds.model.Cd;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DetalheCdFragment extends Fragment {
    private static final String EXTRA_CD = "param1";

    @Bind(R.id.text_titulo)
    TextView mTextTitulo;
    @Bind(R.id.text_banda)
    TextView mTextBanda;
    @Bind(R.id.text_faixas)
    TextView mTextFaixa;
    

    private Cd mCd;

  public static DetalheCdFragment newInstance(Cd cd) {
        DetalheCdFragment fragment = new DetalheCdFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(cd);
        args.putParcelable(EXTRA_CD, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable p = getArguments().getParcelable(EXTRA_CD);
            mCd =  Parcels.unwrap(p);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detalhe_cd, container, false);
        ButterKnife.bind(this, view);

        mTextTitulo.setText(mCd.getTitulo());
        mTextBanda.setText(mCd.getBanda());
        mTextFaixa.setText(String.valueOf(mCd.getFaixas()));
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.meuBotao)
    public void meubotao(){
        Toast.makeText(getContext(), "Executando MUSICA", Toast.LENGTH_SHORT).show();;
    }
}
