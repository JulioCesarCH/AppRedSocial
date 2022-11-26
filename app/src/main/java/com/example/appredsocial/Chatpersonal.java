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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class Chatpersonal extends AppCompatActivity {
    private TextView tvNombre;
    private CircleImageView FotoContacto;
    private RecyclerView RecyclerMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private MensajesAdapter adapterMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatpersonal);

        Toolbar toolbarChatp = findViewById(R.id.includeChatPers);
        toolbarChatp.setTitle("");
        setSupportActionBar(toolbarChatp);

        RecyclerMensajes=findViewById(R.id.RecyclerMensajes);
        tvNombre=findViewById(R.id.tvContacto);
        FotoContacto=findViewById(R.id.FotoContacto);
        txtMensaje=findViewById(R.id.txtMensaje);
        btnEnviar=findViewById(R.id.btnEnviar);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String currentDateandTime = simpleDateFormat.format(new Date());

        Bundle contacto = getIntent().getExtras();
        String Contac = contacto.getString("Contac");
        tvNombre.setText(Contac);

        Bundle fotocontacto = getIntent().getExtras();
        Integer FotoContac = fotocontacto.getInt("FotoContac");
        FotoContacto.setImageResource(FotoContac);

        adapterMsj = new MensajesAdapter(this);
        LinearLayoutManager msjLayout=new LinearLayoutManager(this);
        RecyclerMensajes.setLayoutManager(msjLayout);
        RecyclerMensajes.setAdapter(adapterMsj);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterMsj.addMensaje(new Mensajes(txtMensaje.getText().toString(),"1",currentDateandTime));
                txtMensaje.setText("");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuchatperson,menu);
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