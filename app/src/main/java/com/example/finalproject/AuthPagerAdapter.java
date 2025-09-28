package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AuthPagerAdapter extends FragmentStateAdapter {

    public AuthPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // يعرض LoginFragment في التبويب الأول و SignupFragment في الثاني
        if (position == 0) {
            return new LoginFragment();
        } else {
            return new SignupFragment();
        }
    }

    @Override
    public int getItemCount() {
        // لدينا تبويبان فقط: Login و Signup
        return 2;
    }
}
