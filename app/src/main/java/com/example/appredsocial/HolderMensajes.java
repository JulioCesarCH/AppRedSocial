package com.example.appredsocial;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HolderMensajes extends RecyclerView.ViewHolder{
    private TextView mensaje;
    private TextView hora;
    public HolderMensajes(View itemView){
        super(itemView);
        mensaje=itemView.findViewById(R.id.mensajeMsj);
        hora=itemView.findViewById(R.id.horaMsj);
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

}
