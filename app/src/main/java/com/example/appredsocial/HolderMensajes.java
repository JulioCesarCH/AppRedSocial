package com.example.appredsocial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensajes extends RecyclerView.ViewHolder{
    private TextView nombre;
    private TextView mensaje;
    private TextView hora;
    private CircleImageView fotoMsj;
    public HolderMensajes(View itemView){
        super(itemView);
        nombre=itemView.findViewById(R.id.nombreMsj);
        mensaje=itemView.findViewById(R.id.mensajeMsj);
        hora=itemView.findViewById(R.id.horaMsj);
        fotoMsj=itemView.findViewById(R.id.FotoPerfilMsj);

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

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public CircleImageView getFotoMsj() {
        return fotoMsj;
    }

    public void setFotoMsj(CircleImageView fotoMsj) {
        this.fotoMsj = fotoMsj;
    }
}
