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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityNoticias extends AppCompatActivity {
    TextView TvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        Toolbar udhToolbar = findViewById(R.id.includeUDH2);
        udhToolbar.setTitle("");
        setSupportActionBar(udhToolbar);
        TvUser= findViewById(R.id.tvLogin);

        Bundle usuario = getIntent().getExtras();
        String User = usuario.getString("User");
        TvUser.setText(User);

        List<Noticias> noticias = new ArrayList<>();
        noticias.add( new Noticias(R.drawable.noticia1,"en las universidades el poder pasa de los profesores a los estudiantes","10/10/2022"));
        noticias.add( new Noticias(R.drawable.noticia2,"Universidades nacionales recibieron S/ 498 millones de canon y regalías este año","07/07/2022"));
        noticias.add( new Noticias(R.drawable.noticia3,"¿por qué las universidades pueden perder la acreditación de alta calidad?","01/01/2022"));

        NoticiasAdapter adapter = new NoticiasAdapter(noticias,this);
        RecyclerView recyclerView =findViewById(R.id.recyclerNoticias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
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
                Toast.makeText(ActivityNoticias.this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent intent1 = new Intent(ActivityNoticias.this, ActivityChat.class);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intent2= new Intent(ActivityNoticias.this, ActivityNoticias.class);
                startActivity(intent2);
                return true;
            case R.id.item4:
                Toast.makeText(ActivityNoticias.this, "Salir", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}