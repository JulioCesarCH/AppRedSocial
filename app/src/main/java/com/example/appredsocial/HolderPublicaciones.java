package com.example.appredsocial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class HolderPublicaciones extends RecyclerView.ViewHolder{
    private TextView nombre;
    private TextView mensaje;
    private TextView fechahora;
    public HolderPublicaciones(View itemView){
        super(itemView);
        nombre=itemView.findViewById(R.id.nombrePost);
        mensaje=itemView.findViewById(R.id.mensajePost);
        fechahora=itemView.findViewById(R.id.fechahoraPost);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getMensaje() {
        return mensaje;
    }

    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public TextView getFechahora() {
        return fechahora;
    }

    public void setFechahora(TextView fechahora) {
        this.fechahora = fechahora;
    }
}
