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


            View view = inflater.inflate(R.layout.onboarding_page4, container, false);


            Button loginButton = view.findViewById(R.id.login_button);
            Button signUpButton = view.findViewById(R.id.signup_button);

            loginButton.setOnClickListener(v -> {
                navigateToAuthWelcomeScreen();
            });

            signUpButton.setOnClickListener(v -> {
                navigateToAuthWelcomeScreen();
            });

            return view;
        }

        private void navigateToAuthWelcomeScreen() {
            Intent intent = new Intent(getActivity(), AuthWelcomeActivity.class);
            startActivity(intent);

            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }

