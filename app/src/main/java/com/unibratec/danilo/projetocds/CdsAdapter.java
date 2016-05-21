package com.unibratec.danilo.projetocds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unibratec.danilo.projetocds.model.Cd;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by misael-junior on 23/04/16.
 */
public class CdsAdapter extends ArrayAdapter<Cd> {

    public CdsAdapter(Context context, List<Cd> cds) {
        super(context, 0, cds);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cd cds = getItem(position);

        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_cd, parent, false);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Glide.with(getContext()).load(cds.getCapa()).into(viewHolder.imageView);
        viewHolder.txtTitulo.setText(cds.getTitulo());
        viewHolder.txtBanda.setText(cds.getBanda());
        //viewHolder.txtFaixas.setText(cds.getFaixas());

        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.image_capa)
        ImageView imageView;
        @Bind(R.id.text_titulo)
        TextView txtTitulo;
        @Bind(R.id.text_banda)
        TextView txtBanda;
        //@Bind(R.id.text_faixas)
        //TextView txtFaixas;

        public ViewHolder(View parent){
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }

}
