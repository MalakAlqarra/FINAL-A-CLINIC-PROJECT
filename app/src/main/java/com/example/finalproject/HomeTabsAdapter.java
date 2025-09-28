package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeTabsAdapter extends FragmentStateAdapter {
    private final String[] tabTitles = {"Doctor", "Appointments", "Hospital", "records"};

    public HomeTabsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DoctorFragment(); // 👈 تحتاج لإنشاء هذا الكلاس
            case 1:
                return new AppointmentsFragment(); // 👈 تحتاج لإنشاء هذا الكلاس
            case 2:
                return new HospitalFragment(); // 👈 تحتاج لإنشاء هذا الكلاس
            case 3:
                return new recordsFragment(); // 👈 تحتاج لإنشاء هذا الكلاس
            default:
                return new DoctorFragment();
        }
    }

    @Override
    public int getItemCount() {
        return tabTitles.length; // سيُرجع 4
    }

    // يمكن إضافة دالة للحصول على العنوان إذا كنت تستخدم FragmentPagerAdapter
    // لكن في ViewPager2، يتم ربط العناوين في الـ Activity مباشرة


}
