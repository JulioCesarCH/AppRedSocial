package com.example.appredsocial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ViewHolder> {
    List<Noticias> datos;
    LayoutInflater layoutInflater;
    Context context;

    public NoticiasAdapter(List<Noticias> datos, Context context) {
        this.datos = datos;
        this.layoutInflater = layoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public NoticiasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenidonoticia,parent,false);
        return new NoticiasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiasAdapter.ViewHolder holder, int position) {
        holder.juntarData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDescripcion;
        TextView tvFecha;
        ImageView ivFoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto=itemView.findViewById(R.id.ivFoto);
            tvDescripcion=itemView.findViewById(R.id.tvDescripcion);
            tvFecha=itemView.findViewById(R.id.tvFecha);
        }
        public void juntarData(Noticias noticia){
            ivFoto.setImageResource(noticia.getImagen());
            tvDescripcion.setText(noticia.getDescripcion());
            tvFecha.setText(noticia.getFecha());
        }
    }
}
