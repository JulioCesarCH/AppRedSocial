package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnCuenta;
    EditText TUser,TPassw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        btnCuenta=findViewById(R.id.btnCuenta);

        TUser=findViewById(R.id.edtEmail);
        TPassw=findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User,Passw;
                User=TUser.getText().toString();
                Passw=TPassw.getText().toString();
                if ("julioc.cuevah@gmail.com".equals(User) && "123".equals(Passw)) {
                    Intent intent = new Intent(MainActivity.this,ActivityHome.class);
                    intent.putExtra("User", User);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Datos de Acceso Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityUser.class);
                startActivity(intent);
            }
        });
    }
}