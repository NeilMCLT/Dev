package com.example.neil_handyhelps;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

public class CompleteAddress extends AppCompatActivity {

    // UI elements
    TextInputEditText textInputEditTextAddressLine1, textInputEditTextAddressLine2, textInputEditTextBarangay,
            textInputEditTextLongitude, textInputEditTextLatitude;
    Button buttonSubmit, buttonCurrentLoc;
    ProgressBar progressBar;

    // Variables to store user data
    String addressline1, addressline2, barangay, longitude, latitude;



    // Location-related variables
    private FusedLocationProviderClient fusedLocationClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    // Location permission request code
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;

    // Flag to check if the current location button is clicked
    private boolean isCurrentLocationClicked = false;

    // Add a global variable to store the last geocoded address
    private Address lastGeocodedAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_address);

        // Initialize UI elements
        textInputEditTextAddressLine1 = findViewById(R.id.addressline1);
        textInputEditTextAddressLine2 = findViewById(R.id.addressline2);
        textInputEditTextBarangay = findViewById(R.id.barangay);
        textInputEditTextLongitude = findViewById(R.id.longitude);
        textInputEditTextLatitude = findViewById(R.id.latitude);
        buttonSubmit = findViewById(R.id.Submit);
        buttonCurrentLoc = findViewById(R.id.currentloc);
        progressBar = findViewById(R.id.loading);


        // Retrieve the address details from the intent
        Intent intent = getIntent();
        addressline1 = intent.getStringExtra("addressline1");
        addressline2 = intent.getStringExtra("addressline2");
        barangay = intent.getStringExtra("barangay");
        longitude = intent.getStringExtra("longitude");
        latitude = intent.getStringExtra("latitude");

        // Set the retrieved address details to the respective fields
        textInputEditTextAddressLine1.setText(addressline1);
        textInputEditTextAddressLine2.setText(addressline2);
        textInputEditTextBarangay.setText(barangay);
        textInputEditTextLongitude.setText(longitude);
        textInputEditTextLatitude.setText(latitude);

        // Add TextWatcher to validate input fields in real-time
        textInputEditTextAddressLine1.addTextChangedListener(new MyTextWatcher(textInputEditTextAddressLine1));
        textInputEditTextBarangay.addTextChangedListener(new MyTextWatcher(textInputEditTextBarangay));

        // Set click listener for submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputFields()) {
                    progressBar.setVisibility(View.VISIBLE);

                    // Prepare the address details to pass back to Registration activity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("addressline1", textInputEditTextAddressLine1.getText().toString().trim());
                    resultIntent.putExtra("addressline2", textInputEditTextAddressLine2.getText().toString().trim());
                    resultIntent.putExtra("barangay", textInputEditTextBarangay.getText().toString().trim());
                    resultIntent.putExtra("longitude", textInputEditTextLongitude.getText().toString().trim());
                    resultIntent.putExtra("latitude", textInputEditTextLatitude.getText().toString().trim());

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });

        // Set click listener for currentloc button
        buttonCurrentLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCurrentLocationClicked = true;
                textInputEditTextAddressLine2.setText("");
                textInputEditTextBarangay.setText("");
                textInputEditTextAddressLine1.setFocusable(false);
                textInputEditTextAddressLine2.setVisibility(View.GONE);
                textInputEditTextBarangay.setVisibility(View.GONE);
                checkLocationPermission();
            }
        });

    }

    // TextWatcher inner class for validation
    private class MyTextWatcher implements TextWatcher {
        private TextInputEditText editText;

        MyTextWatcher(TextInputEditText editText) {
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Validate the input field
            validateInputField(editText);
        }
    }

    // Method to validate an input field and set error if necessary
    private void validateInputField(TextInputEditText editText) {
        String input = editText.getText().toString().trim();
        String errorMessage = null;

        if (editText == textInputEditTextAddressLine1) {
            errorMessage = input.isEmpty() ? "Please enter Address Line 1" : null;
        } else if (editText == textInputEditTextBarangay) {
            if (!isCurrentLocationClicked && input.isEmpty()) {
                errorMessage = "Please enter Barangay";
            }
        }

        setError(editText, errorMessage);
    }

    // Method to set error for a TextInputEditText
    private void setError(TextInputEditText editText, String errorMessage) {
        TextInputLayout textInputLayout = (TextInputLayout) editText.getParent().getParent();
        textInputLayout.setError(errorMessage);
        textInputLayout.setErrorEnabled(errorMessage != null && !errorMessage.isEmpty());
    }

    // Method to clear all errors in the TextInputEditText fields
    private void clearErrors() {
        setError(textInputEditTextAddressLine1, null);
        setError(textInputEditTextAddressLine2, null);
        setError(textInputEditTextBarangay, null);
    }

    // Method to validate all input fields
    private boolean validateInputFields() {
        clearErrors();

        // Get user input values
        addressline1 = textInputEditTextAddressLine1.getText().toString().trim();
        addressline2 = textInputEditTextAddressLine2.getText().toString().trim();
        barangay = textInputEditTextBarangay.getText().toString().trim();
        longitude = textInputEditTextLongitude.getText().toString().trim();
        latitude = textInputEditTextLatitude.getText().toString().trim();

        boolean hasErrors = false;
        TextInputEditText firstErrorField = null;

        // Validate Address Line 1
        if (addressline1.isEmpty()) {
            setError(textInputEditTextAddressLine1, "Please enter Address Line 1");
            hasErrors = true;
            firstErrorField = textInputEditTextAddressLine1;
        } else {
            setError(textInputEditTextAddressLine1, null);
        }

        // Validate Barangay if not empty and not current location clicked
        if (!isCurrentLocationClicked && barangay.isEmpty()) {
            setError(textInputEditTextBarangay, "Please enter Barangay");
            hasErrors = true;
            if (firstErrorField == null) {
                firstErrorField = textInputEditTextBarangay;
            }
        } else {
            setError(textInputEditTextBarangay, null);
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

    // Method to check location permission and request if not granted
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (isCurrentLocationClicked) {
                // The "currentloc" button is clicked, so get the current location
                getCurrentLocation();
            }
        } else {
            // Request location permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    // Method to get the current location
    private void getCurrentLocation() {
        if (isLocationPermissionGranted()) {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            createLocationRequest();
            displayLocationSettingsRequest();
        }
    }

    // Method to create a location request
    private void createLocationRequest() {
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        startLocationUpdates();
    }

    // Method to start location updates
    private void startLocationUpdates() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                // Get user's last known location
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    // Update address fields from the given location
                    new GeocodeAsyncTask(CompleteAddress.this).execute(location);
                }
            }
        };

        // Request location updates
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
        }
    }

    // Method to update address fields from the given location
    private void updateAddressFieldsFromLocation(Address address) {
        StringBuilder addressLinesBuilder = new StringBuilder();

        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            String addressLine = address.getAddressLine(i);
            if (addressLine != null) {
                addressLinesBuilder.append(addressLine);
                if (i < address.getMaxAddressLineIndex()) {
                    addressLinesBuilder.append(", ");
                }
            }
        }

        textInputEditTextAddressLine1.setText(addressLinesBuilder.toString());
        textInputEditTextAddressLine2.setText(""); // AddressLine2 is not used in this implementation

        // Set the longitude and latitude values
        textInputEditTextLongitude.setText(String.valueOf(address.getLongitude()));
        textInputEditTextLatitude.setText(String.valueOf(address.getLatitude()));
    }

    // Method to check if location permission is granted
    private boolean isLocationPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }

    // Method to display the location settings request if location is turned off
    private void displayLocationSettingsRequest() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());

        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                // All location settings are satisfied. Get the current location.
                getCurrentLocation();
            }
        });

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Location settings are not satisfied. Show the user a dialog to turn on location.
                if (e instanceof ResolvableApiException) {
                    try {
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(CompleteAddress.this,
                                LOCATION_PERMISSION_REQUEST_CODE);
                    } catch (IntentSender.SendIntentException sendEx) {
                        sendEx.printStackTrace();
                    }
                } else {
                    // Show a custom dialog to prompt the user to enable location
                    showEnableLocationDialog();
                }
            }
        });
    }

    // Method to show a custom dialog to prompt the user to enable location
    private void showEnableLocationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Location is turned off");
        builder.setMessage("Please turn on your location to use this feature.");
        builder.setPositiveButton("Enable Location", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Open settings to enable location
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Dismiss the dialog
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    // Method to set location callback to update address fields when the activity is resumed
    private void setLocationCallback() {
        if (isLocationPermissionGranted()) {
            if (locationCallback != null) {
                startLocationUpdates();
            }
        }
    }

    // Method to remove location callback when the activity is paused
    private void removeLocationCallback() {
        stopLocationUpdates();
    }

    private void stopLocationUpdates() {
        if (fusedLocationClient != null && locationCallback != null) {
            fusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        setLocationCallback();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeLocationCallback();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setLocationCallback();
    }

    @Override
    protected void onStop() {
        super.onStop();
        removeLocationCallback();
    }

    // AsyncTask to perform geocoding in the background
    private static class GeocodeAsyncTask extends AsyncTask<Location, Void, Address> {

        private WeakReference<CompleteAddress> activityReference;

        GeocodeAsyncTask(CompleteAddress activity) {
            activityReference = new WeakReference<>(activity);
        }

        @Override
        protected Address doInBackground(Location... locations) {
            CompleteAddress activity = activityReference.get();
            if (activity == null || activity.isFinishing()) {
                return null;
            }

            Geocoder geocoder = new Geocoder(activity, Locale.getDefault());
            Location location = locations[0];

            try {
                // Check if the location is already geocoded
                if (activity.lastGeocodedAddress != null &&
                        activity.lastGeocodedAddress.getLatitude() == location.getLatitude() &&
                        activity.lastGeocodedAddress.getLongitude() == location.getLongitude()) {
                    return activity.lastGeocodedAddress;
                } else {
                    // Geocode the location
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (!addresses.isEmpty()) {
                        Address address = addresses.get(0);
                        activity.lastGeocodedAddress = address; // Cache the geocoded address
                        return address;
                    } else {
                        // Reset the cached address
                        activity.lastGeocodedAddress = null;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Reset the cached address on error
                activity.lastGeocodedAddress = null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Address address) {
            CompleteAddress activity = activityReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }

            if (address != null) {
                activity.updateAddressFieldsFromLocation(address);
            } else {
                Toast.makeText(activity, "Address not found for the current location", Toast.LENGTH_SHORT).show();
            }

            activity.progressBar.setVisibility(View.GONE);
        }
    }
}