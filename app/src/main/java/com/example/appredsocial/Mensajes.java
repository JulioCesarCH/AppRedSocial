package com.example.appredsocial;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Mensajes  {
    private String mensaje;
    private String typeMensaje;
    private String hora;

    public Mensajes() {
    }

    public Mensajes(String mensaje, String typeMensaje, String hora) {
        this.mensaje = mensaje;
        this.typeMensaje = typeMensaje;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
