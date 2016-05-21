package com.unibratec.danilo.projetocds.model;

import java.util.List;


public class Genero {
    String nome;
    List<Cd> cds;

    public String getNome(){
        return  nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Cd> getCds(){
        return cds;
    }

    public void setCds(List<Cd> cds){
        this.cds = cds;
    }

}
