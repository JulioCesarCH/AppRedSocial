package com.example.appredsocial;

public class Contactos {
    private int imagen;
    private String nombres;

    public Contactos(int imagen, String nombres) {
        this.imagen = imagen;
        this.nombres = nombres;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
