package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 3000; // 3 ثانية

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            SessionManager session = new SessionManager(SplashActivity.this);

            // أول مرة تشغيل → Onboarding
            boolean isFirstRun = getSharedPreferences("app_prefs", MODE_PRIVATE)
                    .getBoolean("isFirstRun", true);

            if (isFirstRun) {
                getSharedPreferences("app_prefs", MODE_PRIVATE)
                        .edit().putBoolean("isFirstRun", false).apply();

                startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
            } else if (!session.isLoggedIn()) {
                startActivity(new Intent(SplashActivity.this, AuthTabsActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }

            finish();
        }, SPLASH_TIME_OUT);
    }
}
