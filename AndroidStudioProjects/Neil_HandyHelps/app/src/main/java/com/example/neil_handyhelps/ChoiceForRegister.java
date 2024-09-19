package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceForRegister extends AppCompatActivity {

    Button buttonHomeowner, buttonWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_for_register);
        buttonHomeowner = findViewById(R.id.Homeowner);
        buttonWorker = findViewById(R.id.Worker);

        buttonHomeowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();
            }
        });

        buttonWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Worker_Registration.class));
                finish();
            }
        });


    }
}
