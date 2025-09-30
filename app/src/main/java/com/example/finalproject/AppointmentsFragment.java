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

import java.util.List;

public class AppointmentsFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppointmentAdapter adapter;
    private List<AppointmentModel> appointmentList;

    public AppointmentsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointments, container, false);

        recyclerView = view.findViewById(R.id.recyclerAppointments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // جلب المواعيد من التخزين
        appointmentList = com.example.finalproject.AppointmentStorage.getAppointments();
        adapter = new AppointmentAdapter(appointmentList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // تحديث القائمة عند الرجوع من DoctorFragment
        if (adapter != null) {
            appointmentList = com.example.finalproject.AppointmentStorage.getAppointments();
            adapter.updateAppointments(appointmentList);
        }
    }
}
