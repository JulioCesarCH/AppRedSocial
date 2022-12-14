package com.example.appredsocial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ViewHolder>
implements View.OnClickListener{
    List<Contactos> datos;
    LayoutInflater layoutInflater;
    Context context;
    View.OnClickListener listener;

    public ContactosAdapter(List<Contactos> datos, Context context) {
        this.datos = datos;
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenidochat,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntarData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        ImageView ivFoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto=itemView.findViewById(R.id.ivFoto);
            tvNombre=itemView.findViewById(R.id.tvNombre);

        }
        public void juntarData(Contactos contacto){
            ivFoto.setImageResource(contacto.getImagen());
            tvNombre.setText(contacto.getNombres());
        }
    }
}
