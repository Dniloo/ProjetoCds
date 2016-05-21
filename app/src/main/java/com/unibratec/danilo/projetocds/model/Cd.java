package com.unibratec.danilo.projetocds.model;

import org.parceler.Parcel;

@Parcel
public class Cd {

     String titulo;
     String banda;
     int faixas;
	 String capa;

    @Override
    public String toString() {
        return  "Titulo='" + getTitulo() +"\n"+
                " Banda='" + getBanda() +"\n"+
                "Faixas=" + getFaixas();
    }

    public Cd() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getFaixas() {
        return faixas;
    }

    public void setFaixas(int faixas) {
        this.faixas = faixas;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
}