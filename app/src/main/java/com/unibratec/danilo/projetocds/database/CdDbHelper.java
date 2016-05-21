package com.unibratec.danilo.projetocds.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DML on 19/05/2016.
 */
public class CdDbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "cds_db";

    public CdDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + CdCantract.TABLE_NAME +"(" +
                CdCantract._ID      +" INTEGER PRIMARY KEY AUTOINCLEMENT, " +
                CdCantract.TITULO   +" TEXT NOT NULL, " +
                CdCantract.BANDA    +" TEXT NOT NULL, " +
                CdCantract.FAIXAS   +" INTEGER  NOT NULL, " +
                CdCantract.CAPA     +" TEXT NOT NULL, " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
