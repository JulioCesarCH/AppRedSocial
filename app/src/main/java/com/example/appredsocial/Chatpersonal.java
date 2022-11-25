package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chatpersonal extends AppCompatActivity {
    private CircleImageView FotoPerfil;
    private TextView tvNombre;
    private RecyclerView RecyclerMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private MensajesAdapter adapterMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatpersonal);

        FotoPerfil=findViewById(R.id.FotoPerfil);
        tvNombre=findViewById(R.id.tvNombre);
        RecyclerMensajes=findViewById(R.id.RecyclerMensajes);
        txtMensaje=findViewById(R.id.txtMensaje);
        btnEnviar=findViewById(R.id.btnEnviar);

        Bundle contacto = getIntent().getExtras();
        String Contac = contacto.getString("Contac");
        tvNombre.setText(Contac);

        adapterMsj = new MensajesAdapter(this);
        LinearLayoutManager msjLayout=new LinearLayoutManager(this);
        RecyclerMensajes.setLayoutManager(msjLayout);
        RecyclerMensajes.setAdapter(adapterMsj);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterMsj.addMensaje(new Mensajes(txtMensaje.getText().toString(),"","","1","00:00"));
            }
        });
        adapterMsj.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

    }
    private void setScrollbar(){
        RecyclerMensajes.scrollToPosition(adapterMsj.getItemCount()-1);
    }

}