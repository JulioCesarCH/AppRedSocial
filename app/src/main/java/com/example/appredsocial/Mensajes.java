package com.example.appredsocial;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Mensajes  {
    private String mensaje;
    private String nombre;
    private String fotoPerfil;
    private String typeMensaje;
    private String hora;

    public Mensajes() {
    }

    public Mensajes(String mensaje, String nombre, String fotoPerfil, String typeMensaje, String hora) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.typeMensaje = typeMensaje;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTypeMensaje() {
        return typeMensaje;
    }

    public void setTypeMensaje(String typeMensaje) {
        this.typeMensaje = typeMensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
