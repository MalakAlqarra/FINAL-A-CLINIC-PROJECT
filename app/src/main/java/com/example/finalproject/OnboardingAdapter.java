package com.example.finalproject;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class OnboardingAdapter extends FragmentStateAdapter {



    public OnboardingAdapter(@NonNull FragmentActivity fragmentActivity, int[] layouts) {
        super(fragmentActivity);
//        this.layouts = layouts;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new onboarding_page1();
        } else if (position == 1) {
            return new onboarding_page2();
        } else if (position == 2) {
            return new onboarding_page3();
        } else {
            return new Onboarding4();
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }}
