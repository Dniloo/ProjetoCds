package com.unibratec.danilo.projetocds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unibratec.danilo.projetocds.model.Cd;

import org.parceler.Parcels;

public class DetalheCdActivity extends AppCompatActivity {

    public static final String EXTRA_CD = "cd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cd);

        Cd cd = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_CD));

        DetalheCdFragment dcf = DetalheCdFragment.newInstance(cd);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detalhe, dcf, "detalhe")
                .commit();
    }
}
