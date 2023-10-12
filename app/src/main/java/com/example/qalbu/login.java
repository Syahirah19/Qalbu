package com.example.qalbu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

@UnstableApi public class login extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btn_login, btn_register;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(
                view -> startActivity(new Intent(login.this, signup.class))
        );

    }

    public void goValidate(View view) {
        String email, password;

        email = edtEmail.getText().toString();
        password = edtPassword.getText().toString();

//        Log.i("Data",email+" |"+password);

        db.collection("User")
                .whereEqualTo("email",email)
                .whereEqualTo("password",password)
                .get()
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()){
//                                Log.i("Data", task.getResult().getDocuments().toString());
                                for (QueryDocumentSnapshot document: task.getResult()){

                                    SharedPreferences.Editor editor = getSharedPreferences("UserPreferences",MODE_PRIVATE).edit();
                                    editor.putString("email",email);
                                    editor.putString("uid",document.getId());
                                    editor.apply();


                                    Intent intent = new Intent(this, dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }
                                if (task.getResult().isEmpty()){
                                    Toast.makeText(login.this,"Email and Password is incorrect",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                );
    }
}