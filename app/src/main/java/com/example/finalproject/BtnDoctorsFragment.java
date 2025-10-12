package com.example.finalproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BtnDoctorsFragment extends Fragment {

    private RecyclerView recyclerView;
    private DoctorAdapter adapter;
    private List<DoctorModel> doctorList;

    public BtnDoctorsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_btn_doctors, container, false);

        recyclerView = view.findViewById(R.id.recyclerDoctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // بيانات تجريبية
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorModel("Dr. Ahmed", "General", "Sun-Thu", "9:00 AM - 2:00 PM"));
        doctorList.add(new DoctorModel("Dr. Layla", "Dental", "Mon-Wed", "10:00 AM - 3:00 PM"));
        doctorList.add(new DoctorModel("Dr. Samer", "Dermatology", "Tue-Fri", "8:00 AM - 1:00 PM"));

        adapter = new DoctorAdapter(doctorList, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
