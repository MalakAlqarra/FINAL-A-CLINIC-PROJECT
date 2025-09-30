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

import com.example.finalproject.DoctorAdapter;
import com.example.finalproject.DoctorModel;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorFragment extends Fragment {

    private RecyclerView recyclerView;
    private DoctorAdapter adapter;
    private List<DoctorModel> doctorList;

    public DoctorFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        recyclerView = view.findViewById(R.id.recyclerDoctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // بيانات تجريبية
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorModel("د. أحمد", "طب عام", "السبت - الخميس", "10:00 - 15:00"));
        doctorList.add(new DoctorModel("د. ليلى", "طب أسنان", "الأحد - الأربعاء", "12:00 - 18:00"));
        doctorList.add(new DoctorModel("د. سامر", "أطفال", "الاثنين - الخميس", "09:00 - 13:00"));

        adapter = new DoctorAdapter(doctorList, getContext());
        recyclerView.setAdapter(adapter);


        return view;
    }
}
