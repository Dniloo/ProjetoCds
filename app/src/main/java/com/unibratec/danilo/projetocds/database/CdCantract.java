package com.unibratec.danilo.projetocds.database;

import android.provider.BaseColumns;

/**
 * Created by DML on 19/05/2016.
 */
public interface CdCantract extends BaseColumns {
    String TABLE_NAME = "cds";
    String TITULO = "titulo";
    String BANDA = "banda";
    String FAIXAS = "faixas";
    String CAPA = "capa";


}
