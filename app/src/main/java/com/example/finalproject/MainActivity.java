package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if (id == R.id.nav_home) {

                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                return true;

            } else if (id == R.id.nav_doctors) {
                selectedFragment = new BtnDoctorsFragment();
            } else if (id == R.id.nav_schedule) {
                selectedFragment = new BtnAppointmentsFragment();
            } else if (id == R.id.nav_profile) {
                selectedFragment = new BtnProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BtnHomeFragment())
                    .commit();
        }


    }
}
