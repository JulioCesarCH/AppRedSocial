package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityChat extends AppCompatActivity {
    TextView TvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbarChat = findViewById(R.id.includeChat);
        toolbarChat.setTitle("");
        setSupportActionBar(toolbarChat);
        TvUser= findViewById(R.id.tvLogin);

        Bundle usuario = getIntent().getExtras();
        String User = usuario.getString("User");
        TvUser.setText(User);

        List<Contactos> contactos=new ArrayList<>();
        contactos.add( new Contactos(R.drawable.fotoh1,"Julio Cueva"));
        contactos.add( new Contactos(R.drawable.fotom1,"Alejandra Leon"));
        contactos.add( new Contactos(R.drawable.fotoh2,"Edgardo Ramirez"));

        ContactosAdapter adapter= new ContactosAdapter(contactos,this);
        RecyclerView recyclerView =findViewById(R.id.recyclerContactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Contac = contactos.get(recyclerView.getChildAdapterPosition(view)).getNombres();
                Integer FotoContac = contactos.get(recyclerView.getChildAdapterPosition(view)).getImagen();
                Intent intent = new Intent(ActivityChat.this, Chatpersonal.class);
                intent.putExtra("Contac", Contac);
                intent.putExtra("FotoContac", FotoContac);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuchat,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap=(Bitmap)data.getExtras().get("data");
    }

}