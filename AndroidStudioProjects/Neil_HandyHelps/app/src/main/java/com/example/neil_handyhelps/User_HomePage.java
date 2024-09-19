package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class User_HomePage extends AppCompatActivity {

    TextView textViewName, textViewEmail, textViewPhone, textViewAddress, textViewId, textViewFetchResult;
    SharedPreferences sharedPreferences;
    Button buttonLogout, buttonFetchUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        textViewName = findViewById(R.id.name);
        textViewEmail = findViewById(R.id.email);
        textViewPhone = findViewById(R.id.phone);
        textViewAddress = findViewById(R.id.address);
        textViewId = findViewById(R.id.id);
        textViewFetchResult = findViewById(R.id.fetchResult);
        buttonLogout = findViewById(R.id.logout);
        buttonFetchUser = findViewById(R.id.fetchProfile);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_message) {
                startActivity(new Intent(getApplicationContext(), User_Message.class));
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), User_Profile.class));
                finish();
                return true;
            }
            return false;
        });


        sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);

        if (!sharedPreferences.getString("logged", "false").equals("true")) {
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        }

        updateProfileData();

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });

        buttonFetchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchUserProfile();
            }
        });
    }

    // Method to update the profile data on the UI
    private void updateProfileData() {
        textViewName.setText(sharedPreferences.getString("name", ""));
        textViewEmail.setText(sharedPreferences.getString("email", ""));
        textViewPhone.setText(sharedPreferences.getString("phone", ""));
        textViewAddress.setText(sharedPreferences.getString("address", ""));
        textViewId.setText(sharedPreferences.getString("id", ""));
    }

    // Method to logout the user and navigate to the Login activity
    private void logoutUser() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://192.168.100.235/login-registration-android/logout.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success")) {
                            clearSharedPreferences();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                            finish();
                        } else {
                            Toast.makeText(User_HomePage.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
            protected Map<String, String> getParams() {
                Map<String, String> paramV = new HashMap<>();
                paramV.put("email", sharedPreferences.getString("email", ""));
                paramV.put("apiKey", sharedPreferences.getString("apikey", ""));
                return paramV;
            }
        };

        queue.add(stringRequest);
    }

    // Method to clear the shared preferences
    private void clearSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("logged", "false");
        editor.putString("name", "");
        editor.putString("email", "");
        editor.putString("phone", "");
        editor.putString("address", "");
        editor.putString("id", "");
        editor.putString("apikey", "");
        editor.apply();
    }

    // Method to fetch the user profile and display the result on the UI
    private void fetchUserProfile() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://192.168.100.235/login-registration-android/profile.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textViewFetchResult.setText(response);
                        textViewFetchResult.setVisibility(View.VISIBLE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }) {
            protected Map<String, String> getParams() {
                Map<String, String> paramV = new HashMap<>();
                paramV.put("email", sharedPreferences.getString("email", ""));
                paramV.put("apiKey", sharedPreferences.getString("apikey", ""));
                return paramV;
            }
        };

        queue.add(stringRequest);
    }
}
