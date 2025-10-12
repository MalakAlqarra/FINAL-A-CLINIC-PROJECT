package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;


import com.bumptech.glide.Glide;

import java.util.Locale;

public class BtnProfileFragment extends Fragment {

    private ImageView imgProfile;
    private TextView txtName;
    private Button btnEditProfile, btnLogout, btnMap, btnLanguage;
    private Switch switchTheme;

    public BtnProfileFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btn_profile, container, false);

        imgProfile = view.findViewById(R.id.imgProfile);
        txtName = view.findViewById(R.id.txtName);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnLogout = view.findViewById(R.id.btnLogout);
        btnMap = view.findViewById(R.id.btnMap);
        btnLanguage = view.findViewById(R.id.btnLanguage);
        switchTheme = view.findViewById(R.id.switchTheme);

        Glide.with(this)
                .load("https://cdn-icons-png.flaticon.com/512/847/847969.png")
                .into(imgProfile);

        btnEditProfile.setOnClickListener(v ->
                txtName.setText("Edited User")
        );

        btnLogout.setOnClickListener(v ->
                startActivity(new Intent(getActivity(), LoginActivity.class))
        );

        btnMap.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Al-Quds Clinic, Gaza");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        btnLanguage.setOnClickListener(v -> switchLanguage());

        // Dark/Light Mode
        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        return view;
    }

    private void switchLanguage() {
        String current = Locale.getDefault().getLanguage();
        Locale locale;
        if (current.equals("en")) {
            locale = new Locale("ar");
        } else {
            locale = new Locale("en");
        }
        Locale.setDefault(locale);
        SharedPreferences.Editor editor = getActivity()
                .getSharedPreferences("settings", getContext().MODE_PRIVATE).edit();
        editor.putString("My_Lang", locale.getLanguage());
        editor.apply();

        getActivity().recreate();
    }
}
