package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityHome extends AppCompatActivity {
    Button btnChat;
    Button btnNoticia;
    Button btnPost;
    TextView TvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar udhToolbar = findViewById(R.id.includeUDH);
        udhToolbar.setTitle("");
        setSupportActionBar(udhToolbar);

        btnChat = findViewById(R.id.btnChat);
        btnNoticia = findViewById(R.id.btnNoticia);
        btnPost=findViewById(R.id.btnPost);
        TvUser= findViewById(R.id.tvLogin);

        Bundle usuario = getIntent().getExtras();
        String User = usuario.getString("User");
        TvUser.setText(User);

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ActivityChat.class);
                intent.putExtra("User", User);
                startActivity(intent);
            }
        });
        btnNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ActivityNoticias.class);
                intent.putExtra("User", User);
                startActivity(intent);
            }
        });
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, Publicacion.class);
                intent.putExtra("User", User);
                startActivity(intent);
            }
        });
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
                Toast.makeText(ActivityHome.this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent intent1 = new Intent(ActivityHome.this, ActivityChat.class);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intent2= new Intent(ActivityHome.this, ActivityNoticias.class);
                startActivity(intent2);
                return true;
            case R.id.item4:
                Toast.makeText(ActivityHome.this, "Salir", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}