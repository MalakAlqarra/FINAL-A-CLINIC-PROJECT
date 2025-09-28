// AuthWelcomeActivity.java
package com.example.finalproject; // 👈 تأكد من هذا السطر!

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.AuthTabsActivity;
import com.example.finalproject.R;

public class AuthWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_welcome);

        Button doctorButton = findViewById(R.id.doctor_button);
        Button patientButton = findViewById(R.id.patient_button);

        doctorButton.setOnClickListener(v -> {
            navigateToAuthScreen(true);
        });

        patientButton.setOnClickListener(v -> {
            navigateToAuthScreen(false);
        });
    }

    private void navigateToAuthScreen(boolean isDoctor) {
        Intent intent = new Intent(AuthWelcomeActivity.this, AuthTabsActivity.class);
        intent.putExtra("is_doctor", isDoctor);
        startActivity(intent);
        finish(); // يجب أن تكون مضافة!
    }
}