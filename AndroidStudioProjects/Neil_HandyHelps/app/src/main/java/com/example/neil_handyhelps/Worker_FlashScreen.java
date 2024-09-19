package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class Worker_FlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_flash_screen);

        // Proceed to the Login activity
        Intent intent = new Intent(Worker_FlashScreen.this, Login.class);
        startActivity(intent);
        finish(); // Close the current activity
    }
}
