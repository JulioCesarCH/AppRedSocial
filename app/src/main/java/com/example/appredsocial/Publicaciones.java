package com.example.appredsocial;

public class Publicaciones {
    private String nombrep;
    private String mensajep;
    private String fechahorap;
    private String typeMensajep;

    public Publicaciones(String nombrep, String mensajep, String fechahorap, String typeMensajep) {
        this.nombrep = nombrep;
        this.mensajep = mensajep;
        this.fechahorap = fechahorap;
        this.typeMensajep = typeMensajep;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getMensajep() {
        return mensajep;
    }

    public void setMensajep(String mensajep) {
        this.mensajep = mensajep;
    }

    public String getFechahorap() {
        return fechahorap;
    }

    public void setFechahorap(String fechahorap) {
        this.fechahorap = fechahorap;
    }

    public String getTypeMensajep() {
        return typeMensajep;
    }

    public void setTypeMensajep(String typeMensajep) {
        this.typeMensajep = typeMensajep;
    }
}
