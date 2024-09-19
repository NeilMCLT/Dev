package com.example.neil_handyhelps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Worker_WorkDetails extends AppCompatActivity {

    private TextView workTypeTextView;
    private TextView idTextView;
    private String id;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_work_details);

        workTypeTextView = findViewById(R.id.worktype);
        idTextView = findViewById(R.id.id);

        id = getIntent().getStringExtra("id");
        idTextView.setText("ID: " + id);

        String worktype = getIntent().getStringExtra("worktype");
        if (worktype != null) {
            workTypeTextView.setText("Work Type: " + worktype);
        }

        findViewById(R.id.Submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                submitData();
            }
        });

        requestQueue = Volley.newRequestQueue(this);
    }

    private void submitData() {
        // Get the ID and work type from the intent extras
        String id = getIntent().getStringExtra("id");
        String worktype = getIntent().getStringExtra("worktype");

        // Check if both ID and work type are not null
        if (id != null && worktype != null) {
            // Define the URL of your PHP script
            String url = "http://192.168.100.235/login-registration-android/upload.php";

            // Create a request using Volley
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Handle the response from the PHP script here
                            if (response.equals("success")) {
                                // Success: Redirect to the next activity or perform any desired action
                                Intent intent = new Intent(Worker_WorkDetails.this, Worker_FlashScreen.class);
                                startActivity(intent);
                            } else {
                                // Failure: Show an error message
                                Toast.makeText(Worker_WorkDetails.this, "Data submission failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle errors here
                            error.printStackTrace();
                            Toast.makeText(Worker_WorkDetails.this, "Network error.", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    // Define the parameters to send to the PHP script
                    Map<String, String> params = new HashMap<>();
                    params.put("worktype", worktype);
                    params.put("id", id);
                    // You can add more parameters here if needed
                    return params;
                }
            };

            // Set the retry policy and add the request to the request queue
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    0,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            requestQueue.add(stringRequest);
        } else {
            // Handle the case where ID or work type is null
            Toast.makeText(Worker_WorkDetails.this, "Missing ID or work type.", Toast.LENGTH_SHORT).show();
        }
    }
}
