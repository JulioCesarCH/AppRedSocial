package com.example.appredsocial;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MensajesAdapter extends RecyclerView.Adapter<HolderMensajes> {
    private List<Mensajes> listMensaje=new ArrayList<>();
    private Context c;

    public MensajesAdapter(Context c) {
        this.c = c;
    }
    public void addMensaje(Mensajes m){
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());
    }

    @Override
    public HolderMensajes onCreateViewHolder(ViewGroup parent, int viewType) {
    View v=LayoutInflater.from(c).inflate(R.layout.cardvmensajes,parent,false);
    return new HolderMensajes(v);
    }

    @Override
    public void onBindViewHolder(HolderMensajes holder, int position) {
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        holder.getHora().setText(listMensaje.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
