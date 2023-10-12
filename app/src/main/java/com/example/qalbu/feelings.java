package com.example.qalbu;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class feelings extends AppCompatActivity {

    ImageView btnAngry, btnAnxious, btnThinking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelings);

        btnAngry= findViewById(R.id.btnAngry);
        btnAnxious=findViewById(R.id.btnAnxious);
        btnThinking= findViewById(R.id.btnThinking);

        btnThinking.setOnClickListener(
                view -> startActivity(new Intent(feelings.this, overthinking.class))
        );

        btnAnxious.setOnClickListener(
                view -> startActivity(new Intent(feelings.this, Anxious.class))
        );

        btnAngry.setOnClickListener(
                view -> startActivity(new Intent(feelings.this, angry.class))
        );

    }
}