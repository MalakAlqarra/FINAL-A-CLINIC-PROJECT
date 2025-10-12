package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeTabsAdapter extends FragmentStateAdapter {
    private final String[] tabTitles = {"Doctor", "Appointments", "Hospital", "Records","Profile"};

    public HomeTabsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DoctorFragment();
            case 1:
                return new AppointmentsFragment();
            case 2:
                return new HospitalFragment();
            case 3:
                return new RecordsFragment();
            case 4:
                return new BtnProfileFragment() ;
            default:
                return new DoctorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return tabTitles.length;
    }



}
