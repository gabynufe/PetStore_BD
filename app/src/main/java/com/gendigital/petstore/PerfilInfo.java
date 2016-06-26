package com.gendigital.petstore;
/**
 * Created by Gaby on 10/06/2016.
 */
public class PerfilInfo {
    private int foto;
    private int meGusta;

    public PerfilInfo() {
        this.foto = 0;
        this.meGusta = 0;
    }

    public PerfilInfo(int foto) {
        this.foto = foto;
        this.meGusta = 0;
    }

    public PerfilInfo(int foto, int meGusta) {
        this.foto = foto;
        this.meGusta = meGusta;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getMeGusta() {
        return Integer.toString(meGusta);
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }
    public void incrementaMeGusta() {
        this.meGusta ++;
    }
}