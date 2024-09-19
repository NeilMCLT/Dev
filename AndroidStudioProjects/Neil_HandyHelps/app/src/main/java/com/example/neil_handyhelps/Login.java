package com.example.neil_handyhelps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    TextView textViewRegisterNow, textViewError, textViewForgotPassword;
    TextInputEditText textInputEditTextEmail, textInputEditTextPassword;
    Button buttonSubmit;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    String email, password, name, phone, address, id, apikey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewRegisterNow = findViewById(R.id.registerNow);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonSubmit = findViewById(R.id.Submit);
        textViewError = findViewById(R.id.error);
        progressBar = findViewById(R.id.loading);
        textViewForgotPassword = findViewById(R.id.forget_password);

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPassword.class));
                finish();
            }
        });

        sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);
        if (sharedPreferences.getString("logged", "false").equals("true")) {
            redirectToAppropriateHomePage();
            finish();
        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    textViewError.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);

                    email = String.valueOf(textInputEditTextEmail.getText());
                    password = String.valueOf(textInputEditTextPassword.getText());
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url = "http://192.168.100.235/login-registration-android/login.php";

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    progressBar.setVisibility(View.GONE);
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String status = jsonObject.getString("status");
                                        String message = jsonObject.getString("message");
                                        String source = jsonObject.getString("source"); // Added source field

                                        if (status.equals("success")) {
                                            name = jsonObject.getString("name");
                                            email = jsonObject.getString("email");
                                            phone = jsonObject.getString("phone");
                                            address = jsonObject.getString("address");
                                            id = jsonObject.getString("id");
                                            apikey = jsonObject.getString("apikey");
                                            SharedPreferences.Editor editor = sharedPreferences.edit();
                                            editor.putString("logged", "true");
                                            editor.putString("name", name);
                                            editor.putString("email", email);
                                            editor.putString("phone", phone);
                                            editor.putString("address", address);
                                            editor.putString("id", id);
                                            editor.putString("apikey", apikey);
                                            editor.putString("source", source); // Store the user's role
                                            editor.apply();

                                            redirectToAppropriateHomePage();
                                            finish();
                                        } else {
                                            textViewError.setText(message);
                                            textViewError.setVisibility(View.VISIBLE);
                                            focusOnFirstErrorField();
                                            hidePasswordToggle();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressBar.setVisibility(View.GONE);
                            textViewError.setText(error.getLocalizedMessage());
                            textViewError.setVisibility(View.VISIBLE);
                        }
                    }) {
                        protected Map<String, String> getParams() {
                            Map<String, String> paramV = new HashMap<>();
                            paramV.put("email", email);
                            paramV.put("password", password);
                            return paramV;
                        }
                    };
                    queue.add(stringRequest);
                }
            }
        });

        textViewRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChoiceForRegister.class));
                finish();
            }
        });
    }

    // Method to validate input fields and set errors if necessary
    private boolean validateInputs() {
        String emailInput = textInputEditTextEmail.getText().toString().trim();
        String passwordInput = textInputEditTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(emailInput)) {
            setErrorForTextInput(textInputEditTextEmail, "Email cannot be empty");
            return false;
        } else if (!isValidEmail(emailInput)) {
            setErrorForTextInput(textInputEditTextEmail, "Invalid email format");
            return false;
        } else {
            clearErrorForTextInput(textInputEditTextEmail);
        }

        if (TextUtils.isEmpty(passwordInput)) {
            setErrorForTextInput(textInputEditTextPassword, "Password cannot be empty");
            return false;
        } else {
            clearErrorForTextInput(textInputEditTextPassword);
        }

        return true;
    }

    // Method to set error for a TextInputEditText
    private void setErrorForTextInput(TextInputEditText textInputEditText, String errorMessage) {
        TextInputLayout textInputLayout = (TextInputLayout) textInputEditText.getParent().getParent();
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(errorMessage);
    }

    // Method to clear all errors in the TextInputEditText fields
    private void clearErrorForTextInput(TextInputEditText textInputEditText) {
        TextInputLayout textInputLayout = (TextInputLayout) textInputEditText.getParent().getParent();
        textInputLayout.setErrorEnabled(false);
        textInputLayout.setError(null);
    }

    // Method to focus on the first error field
    private void focusOnFirstErrorField() {
        if (!textInputEditTextEmail.getText().toString().trim().isEmpty()) {
            textInputEditTextEmail.requestFocus();
        } else if (!textInputEditTextPassword.getText().toString().trim().isEmpty()) {
            textInputEditTextPassword.requestFocus();
        }
    }

    // Method to hide the toggle in password when an error shows
    private void hidePasswordToggle() {
        TextInputLayout passwordTextInputLayout = (TextInputLayout) textInputEditTextPassword.getParent().getParent();
        passwordTextInputLayout.setEndIconVisible(false);
    }

    // Method to check if an email is in a valid format
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void redirectToAppropriateHomePage() {
        String source = sharedPreferences.getString("source", "");
        if ("user".equals(source)) {
            Intent intent = new Intent(getApplicationContext(), User_HomePage.class);
            startActivity(intent);
        } else if ("worker".equals(source)) {
            Intent intent = new Intent(getApplicationContext(), Worker_HomePage.class);
            startActivity(intent);
        }
    }
}
