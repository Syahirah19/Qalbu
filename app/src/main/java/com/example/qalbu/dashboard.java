package com.example.qalbu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class dashboard extends AppCompatActivity {

    ImageView btnFeelings, btnRoutine, btnJournal;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnFeelings = findViewById(R.id.btnFeelings);
        btnJournal = findViewById(R.id.btnJournal);
        btnRoutine= findViewById(R.id.btnRoutine);

        btnFeelings.setOnClickListener(
                view -> startActivity(new Intent(dashboard.this, feelings.class))
        );

//        btnJournal.setOnClickListener(
//                (View.OnClickListener) new AlertDialog.Builder(context)
//                        .setTitle("Sorry for the hiccup!")
//                        .setMessage("This page is on repair")
//        );
    }

}