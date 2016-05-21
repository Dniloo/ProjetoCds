package com.unibratec.danilo.projetocds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import com.unibratec.danilo.projetocds.model.Cd;

import org.parceler.Parcels;

public class CdsActivity extends AppCompatActivity
    implements ListaCdFragment.CliqueNoCdListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cds);
    }

    @Override
    public void cdFoiClicado(Cd cd) {
        if (getResources().getBoolean(R.bool.tablet)) {
            DetalheCdFragment dcf = DetalheCdFragment.newInstance(cd);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detalhe, dcf, "detalhe")
                    .commit();
        } else {
            Intent it = new Intent(this, DetalheCdActivity.class);
            Parcelable p = Parcels.wrap(cd);
            it.putExtra(DetalheCdActivity.EXTRA_CD, p);
            startActivity(it);
        }
    }
}
