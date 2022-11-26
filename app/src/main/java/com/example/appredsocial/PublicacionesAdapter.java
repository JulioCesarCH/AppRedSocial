package com.example.appredsocial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PublicacionesAdapter extends RecyclerView.Adapter<HolderPublicaciones>{
    private List<Publicaciones> listPublicacion=new ArrayList<>();
    private Context c;

    public PublicacionesAdapter(Context c) {
        this.c = c;
    }
    public void addPublicacion(Publicaciones p){
        listPublicacion.add(p);
        notifyItemInserted(listPublicacion.size());
    }

    @Override
    public HolderPublicaciones onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.cardvpost,parent,false);
        return new HolderPublicaciones(v);
    }

    @Override
    public void onBindViewHolder(HolderPublicaciones holder, int position) {
        holder.getNombre().setText(listPublicacion.get(position).getNombrep());
        holder.getMensaje().setText(listPublicacion.get(position).getMensajep());
        holder.getFechahora().setText(listPublicacion.get(position).getFechahorap());
    }

    @Override
    public int getItemCount() {
        return listPublicacion.size();
    }
}
