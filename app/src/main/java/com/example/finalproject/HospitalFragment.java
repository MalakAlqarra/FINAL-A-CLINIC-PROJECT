package com.example.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HospitalFragment extends Fragment {

    public HospitalFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);

        TextView txtName = view.findViewById(R.id.txtHospitalName);
        TextView txtAddress = view.findViewById(R.id.txtHospitalAddress);
        Button btnCall = view.findViewById(R.id.btnCall);
        Button btnMap = view.findViewById(R.id.btnMap);

        txtName.setText("Al-Quds Clinic");
        txtAddress.setText("Gaza City, Palestine");

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0599999999"));
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Al-Quds Clinic, Gaza");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        return view;
    }
}
