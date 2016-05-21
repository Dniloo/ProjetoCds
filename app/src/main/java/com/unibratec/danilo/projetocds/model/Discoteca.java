package com.unibratec.danilo.projetocds.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Discoteca {

    @SerializedName("discoteca")
    List<com.unibratec.danilo.projetocds.model.Genero> generos;

    public List<com.unibratec.danilo.projetocds.model.Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<com.unibratec.danilo.projetocds.model.Genero> generos) {
        this.generos = generos;
    }
}
