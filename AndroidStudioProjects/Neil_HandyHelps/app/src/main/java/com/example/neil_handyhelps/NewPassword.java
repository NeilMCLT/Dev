package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class NewPassword extends AppCompatActivity {

    private TextInputEditText editTextNewPassword;
    private TextInputEditText editTextConfirmPassword;
    private Button buttonSubmit;
    private ProgressBar progressBar;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        email = getIntent().getStringExtra("email");

        editTextNewPassword = findViewById(R.id.new_password);
        editTextConfirmPassword = findViewById(R.id.confirm_password);
        buttonSubmit = findViewById(R.id.btnSubmit);
        progressBar = findViewById(R.id.progress);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit() {
        String newPassword = editTextNewPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(newPassword)) {
            setErrorForEditText(editTextNewPassword, "Please enter a new password");
        } else if (newPassword.length() < 8) {
            setErrorForEditText(editTextNewPassword, "Password must be at least 8 characters long");
        } else if (!isPasswordValid(newPassword)) {
            setErrorForEditText(editTextNewPassword, "Password must contain at least one uppercase letter, one lowercase letter, and one digit");
        } else if (!newPassword.equals(confirmPassword)) {
            setErrorForEditText(editTextConfirmPassword, "Passwords do not match");
        } else {
            progressBar.setVisibility(View.VISIBLE);
            updatePassword(email, newPassword);
        }
    }

    private boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }

    private void updatePassword(String email, final String newPassword) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://192.168.100.235/login-registration-android/new-password.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        if (response.equals("success")) {
                            Toast.makeText(getApplicationContext(), "New password set", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed to update password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Failed to update password", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("new-password", newPassword);
                return params;
            }
        };

        queue.add(stringRequest);
    }

    private void setErrorForEditText(TextInputEditText editText, String errorMessage) {
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(editText.getId()).getParent().getParent();
        textInputLayout.setError(errorMessage);
        textInputLayout.setErrorEnabled(true);
    }
}
