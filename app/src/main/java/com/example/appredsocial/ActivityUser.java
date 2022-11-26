package com.example.appredsocial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class ActivityUser extends AppCompatActivity {
    FirebaseFirestore db;
    EditText edtNombre,edtApellido,edtEmail,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        db = FirebaseFirestore.getInstance();

        edtNombre=findViewById(R.id.edtNombre);
        edtApellido=findViewById(R.id.edtApellido);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);

        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void registrar(View view) {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("nombre", edtNombre.getText().toString());
        user.put("apellido", edtApellido.getText().toString());
        user.put("username", edtEmail.getText().toString());
        user.put("password", edtPassword.getText().toString());

        // Add a new document with a generated ID
        db.collection("usuarios")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(ActivityUser.this, "Usuario Registrado con Exito", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivityUser.this,MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(ActivityUser.this, "Error de Registro", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}