package com.example.finalproject;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
public class Onboarding4 extends Fragment {
    

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // ربط الـ Layout الخاص بالشريحة الرابعة
            // 🚨 تأكدي من أن اسم الملف هو R.layout.onboarding_page4
            View view = inflater.inflate(R.layout.onboarding_page4, container, false);

            // 1. ربط الأزرار الموجودة داخل هذه الشريحة
            // 🚨 يجب أن يتطابق الـ ID مع ما هو موجود في ملف XML
            Button loginButton = view.findViewById(R.id.login_button);
            Button signUpButton = view.findViewById(R.id.signup_button);

            // 2. إضافة مُستمع النقر لكل زر
            loginButton.setOnClickListener(v -> {
                navigateToAuthWelcomeScreen();
            });

            signUpButton.setOnClickListener(v -> {
                navigateToAuthWelcomeScreen();
            });

            return view;
        }

        // دالة الانتقال (موضوعة داخل الـ Fragment لسهولة الاستدعاء)
        private void navigateToAuthWelcomeScreen() {
            // الانتقال إلى شاشة AuthWelcomeActivity
            Intent intent = new Intent(getActivity(), AuthWelcomeActivity.class);
            startActivity(intent);

            // إغلاق الـ Activity الحاضنة (OnboardingActivity)
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }

