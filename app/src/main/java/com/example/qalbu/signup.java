package com.example.qalbu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    EditText edtEmail, edtUsername, edtPassword, edtGender;
    Button btnRegister;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        edtGender = findViewById(R.id.edtGender);
        btnRegister = findViewById(R.id.btnRegister);

//        btnRegister.setOnClickListener(
//                view -> startActivity(new Intent(signup.this, dashboard.class))
//        );


    }

    public void goAccount(View view) {
        String email, password, username, gender;

        email = edtEmail.getText().toString();
        password = edtPassword.getText().toString();
        username = edtUsername.getText().toString();
        gender = edtGender.getText().toString();


        Map<String, Object> data = new HashMap<>();
        data.put("email", email);
        data.put("username", username);
        data.put("password", password);
        data.put("gender", gender);
        data.put("age", "");
        Log.d("Data", data.toString());
        db.collection("User").add(data).addOnCompleteListener(task -> {
            if(task.isComplete()) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(signup.this, dashboard.class));
                }
            }
        });
    }
}