package com.example.appredsocial;

public class Noticias {
    private int imagen;
    private String descripcion;
    private String fecha;

    public Noticias(int imagen, String descripcion, String fecha) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
