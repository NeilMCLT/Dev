package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class Worker_ChooseYourWork extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_choose_your_work);

        id = getIntent().getStringExtra("id");

        CardView plumberCardView = findViewById(R.id.Plumber);
        CardView houseCleanerCardView = findViewById(R.id.Housecleaner);
        CardView electricianCardView = findViewById(R.id.Electrician);
        CardView carpenterCardView = findViewById(R.id.Carpenter);
        CardView laundryServiceCardView = findViewById(R.id.Laundryservice);
        CardView repairmanCardView = findViewById(R.id.Repairman);

        plumberCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Plumber");
            }
        });

        houseCleanerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Housecleaner");
            }
        });

        electricianCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Electrician");
            }
        });

        carpenterCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Carpenter");
            }
        });

        laundryServiceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Laundryservice");
            }
        });

        repairmanCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkerWorkDetailsActivity("Repairman");
            }
        });
    }

    private void startWorkerWorkDetailsActivity(String worktype) {
        Intent intent = new Intent(Worker_ChooseYourWork.this, Worker_WorkDetails.class);
        intent.putExtra("id", id);
        intent.putExtra("worktype", worktype);
        startActivity(intent);
    }
}
