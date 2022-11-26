package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Publicacion extends AppCompatActivity {
    private TextView tvNombre;
    private RecyclerView RecyclerPost;
    private EditText txtMensaje;
    private Button btnPublicar;
    private PublicacionesAdapter adapterPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion);

        Toolbar udhToolbar = findViewById(R.id.includeUDHa);
        udhToolbar.setTitle("");
        setSupportActionBar(udhToolbar);

        RecyclerPost=findViewById(R.id.RecyclerPost);
        tvNombre=findViewById(R.id.tvLogin);
        txtMensaje=findViewById(R.id.txtMensaje);
        btnPublicar=findViewById(R.id.btnPublicar);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String currentDateandTime = simpleDateFormat.format(new Date());

        Bundle usuario = getIntent().getExtras();
        String User = usuario.getString("User");
        tvNombre.setText(User);

        adapterPost = new PublicacionesAdapter(this);
        LinearLayoutManager postLayout=new LinearLayoutManager(this);
        RecyclerPost.setLayoutManager(postLayout);
        RecyclerPost.setAdapter(adapterPost);

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterPost.addPublicacion(new Publicaciones(User,txtMensaje.getText().toString(),currentDateandTime,"1"));
                txtMensaje.setText("");
            }
        });
        adapterPost.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });
    }

    private void setScrollbar(){
        RecyclerPost.scrollToPosition(adapterPost.getItemCount()-1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menured,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                Toast.makeText(Publicacion.this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent intent1 = new Intent(Publicacion.this, ActivityChat.class);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intent2= new Intent(Publicacion.this, ActivityNoticias.class);
                startActivity(intent2);
                return true;
            case R.id.item4:
                Toast.makeText(Publicacion.this, "Salir", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}