package com.example.neil_handyhelps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class Worker_Registration extends AppCompatActivity {

    // UI elements
    TextInputEditText textInputEditTextName, textInputEditTextEmail, textInputEditTextPassword,
            textInputEditTextConfirmPassword, textInputEditTextPhone, textInputEditTextAddress;
    TextInputEditText textInputEditTextLongitude, textInputEditTextLatitude;
    Button buttonSubmit;
    TextView textViewLoginNow;
    ProgressBar progressBar;

    // Variables to store user data
    String name, email, password, confirmPassword, phone;
    String addressline1, addressline2, barangay, longitude, latitude;

    // Request code for CompleteAddress activity
    private static final int REQUEST_COMPLETE_ADDRESS = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_registration);

        // Initialize UI elements
        textInputEditTextName = findViewById(R.id.name);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextPhone = findViewById(R.id.phone);
        textInputEditTextAddress = findViewById(R.id.address);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextConfirmPassword = findViewById(R.id.confirm_password);
        textInputEditTextLongitude = findViewById(R.id.longitude);
        textInputEditTextLatitude = findViewById(R.id.latitude);
        buttonSubmit = findViewById(R.id.Submit);
        textViewLoginNow = findViewById(R.id.loginNow);
        progressBar = findViewById(R.id.loading);

        // Set click listener for address TextView
        textInputEditTextAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the CompleteAddress activity and pass the existing address details
                Intent intent = new Intent(getApplicationContext(), Worker_CompleteAddress.class);
                intent.putExtra("addressline1", addressline1);
                intent.putExtra("addressline2", addressline2);
                intent.putExtra("barangay", barangay);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude", latitude);
                startActivityForResult(intent, REQUEST_COMPLETE_ADDRESS);
            }
        });

        // Set click listener for login text view
        textViewLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the Login activity
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


        // Set click listener for submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputFields()) {
                    progressBar.setVisibility(View.VISIBLE);

                    // Proceed with registration
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url = "http://192.168.100.235/login-registration-android/worker-register.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    progressBar.setVisibility(View.GONE);
                                    if (response.equals("success")) {
                                        // Registration successful
                                        Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        protected Map<String, String> getParams() {
                            // Set parameters for the POST request
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("name", name);
                            paramV.put("email", email);
                            paramV.put("phone", phone);
                            paramV.put("address", constructAddress());
                            paramV.put("longitude", longitude);
                            paramV.put("latitude", latitude);
                            paramV.put("password", password);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);
                }
            }
        });

        // Retrieve the address details from the intent and set them to the address TextView
        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            email = savedInstanceState.getString("email");
            phone = savedInstanceState.getString("phone");
            addressline1 = savedInstanceState.getString("addressline1");
            addressline2 = savedInstanceState.getString("addressline2");
            barangay = savedInstanceState.getString("barangay");
            longitude = savedInstanceState.getString("longitude");
            latitude = savedInstanceState.getString("latitude");
            updateAddressField();
        }
    }

    // Method to update the address field with the concatenated address
    private void updateAddressField() {
        String completeAddress = constructAddress();
        textInputEditTextAddress.setText(completeAddress);
        textInputEditTextLongitude.setText(longitude);
        textInputEditTextLatitude.setText(latitude);
    }

    // Method to construct the address based on valid fields
    private String constructAddress() {
        StringBuilder addressBuilder = new StringBuilder();
        addressBuilder.append(addressline1);

        if (!TextUtils.isEmpty(addressline2)) {
            addressBuilder.append(", ").append(addressline2);
        }

        if (!TextUtils.isEmpty(barangay)) {
            addressBuilder.append(", ").append(barangay);
        }

        return addressBuilder.toString();
    }

    // Method to validate all input fields
    private boolean validateInputFields() {
        clearErrors();

        // Get user input values
        name = textInputEditTextName.getText().toString().trim();
        email = textInputEditTextEmail.getText().toString().trim();
        phone = textInputEditTextPhone.getText().toString().trim();
        password = textInputEditTextPassword.getText().toString().trim();
        confirmPassword = textInputEditTextConfirmPassword.getText().toString().trim();

        boolean hasErrors = false;
        TextInputEditText firstErrorField = null;

        // Validate input fields and set errors if necessary
        if (TextUtils.isEmpty(name)) {
            setError(textInputEditTextName, "Please enter your name");
            hasErrors = true;
            firstErrorField = textInputEditTextName;
        } else {
            setError(textInputEditTextName, null);
        }

        if (TextUtils.isEmpty(email)) {
            setError(textInputEditTextEmail, "Please enter your email");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextEmail;
            }
        } else if (!isValidEmail(email)) {
            setError(textInputEditTextEmail, "Invalid email");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextEmail;
            }
        } else {
            setError(textInputEditTextEmail, null);
        }

        if (TextUtils.isEmpty(phone)) {
            setError(textInputEditTextPhone, "Please enter your phone number");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextPhone;
            }
        } else if (phone.length() != 11 || !phone.startsWith("09")) {
            setError(textInputEditTextPhone, "Invalid phone number");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextPhone;
            }
        } else {
            setError(textInputEditTextPhone, null);
        }

        if (TextUtils.isEmpty(password)) {
            setError(textInputEditTextPassword, "Please enter your password");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextPassword;
            }
        } else if (password.length() < 8) {
            setError(textInputEditTextPassword, "Password must have at least 8 characters");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextPassword;
            }
        } else {
            setError(textInputEditTextPassword, null);
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            setError(textInputEditTextConfirmPassword, "Please confirm your password");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextConfirmPassword;
            }
        } else {
            setError(textInputEditTextConfirmPassword, null);
        }

        if (!password.equals(confirmPassword)) {
            setError(textInputEditTextConfirmPassword, "Passwords do not match");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextConfirmPassword;
            }
        } else {
            setError(textInputEditTextConfirmPassword, null);
        }

        // Handle errors and focus on the first error field
        if (hasErrors) {
            if (firstErrorField != null) {
                firstErrorField.requestFocus();
            }
            return false;
        }

        return true;
    }

    // Method to set error for a TextInputEditText
    private void setError(TextInputEditText editText, String errorMessage) {
        TextInputLayout textInputLayout = (TextInputLayout) editText.getParent().getParent();
        textInputLayout.setError(errorMessage);
        textInputLayout.setErrorEnabled(!TextUtils.isEmpty(errorMessage));
    }

    // Method to clear all errors in the TextInputEditText fields
    private void clearErrors() {
        setError(textInputEditTextName, null);
        setError(textInputEditTextEmail, null);
        setError(textInputEditTextPhone, null);
        setError(textInputEditTextPassword, null);
        setError(textInputEditTextConfirmPassword, null);
    }

    // Method to validate an email address using a regular expression
    private boolean isValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Save instance state to retain data on configuration change or activity pause
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
        outState.putString("email", email);
        outState.putString("phone", phone);
        outState.putString("addressline1", addressline1);
        outState.putString("addressline2", addressline2);
        outState.putString("barangay", barangay);
        outState.putString("longitude", longitude);
        outState.putString("latitude", latitude);
    }

    // Handle the result from CompleteAddress activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_COMPLETE_ADDRESS && resultCode == RESULT_OK) {
            if (data != null) {
                // Extract the address details from the result Intent
                addressline1 = data.getStringExtra("addressline1");
                addressline2 = data.getStringExtra("addressline2");
                barangay = data.getStringExtra("barangay");
                longitude = data.getStringExtra("longitude");
                latitude = data.getStringExtra("latitude");

                // Update the address field with the concatenated address
                updateAddressField();
            }
        }
    }
}
