package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnCuenta;
    EditText TUser,TPassw;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

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
                db.collection("usuarios")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (document.get("username").equals(User) && document.get("password").equals(Passw)) {
                                            Intent intent = new Intent(MainActivity.this,ActivityHome.class);
                                            intent.putExtra("User", User);
                                            startActivity(intent);
                                        }
                                    }
                                    Toast.makeText(MainActivity.this, "Datos de Acceso Incorrectos", Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.w("TAG", "Error getting documents.", task.getException());
                                }
                            }
                        });
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