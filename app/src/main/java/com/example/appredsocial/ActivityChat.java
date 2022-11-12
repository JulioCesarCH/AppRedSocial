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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar udhToolbar = findViewById(R.id.udhToolbar);
        udhToolbar.setTitle("");
        setSupportActionBar(udhToolbar);

        List<Contactos> contactos=new ArrayList<>();
        contactos.add( new Contactos(R.drawable.fotoh1,"Julio Cueva"));
        contactos.add( new Contactos(R.drawable.fotom1,"Alejandra Leon"));
        contactos.add( new Contactos(R.drawable.fotoh2,"Edgardo Ramirez"));

    ContactosAdapter adapter= new ContactosAdapter(contactos,this);
        RecyclerView recyclerView =findViewById(R.id.recyclerContactos);
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
                Toast.makeText(ActivityChat.this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(ActivityChat.this, "Chatear", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Intent intent1 = new Intent(ActivityChat.this, ActivityNoticias.class);
                startActivity(intent1);
                return true;
            case R.id.item4:
                Toast.makeText(ActivityChat.this, "Salir", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}