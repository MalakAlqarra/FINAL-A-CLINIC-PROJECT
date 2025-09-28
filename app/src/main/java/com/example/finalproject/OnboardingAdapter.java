package com.example.finalproject;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class OnboardingAdapter extends FragmentStateAdapter {


    private final int[] layouts;

    // الدالة البانية الصحيحة
    public OnboardingAdapter(@NonNull FragmentActivity fragmentActivity, int[] layouts) {
        super(fragmentActivity);
        this.layouts = layouts;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Onboarding1();
        } else if (position == 1) {
            return new Onboarding2();
        } else if (position == 2) {
            return new Onboarding3();
        } else {
            // 🚨 هذا هو الجزء الحاسم! يجب أن يُنشئ كلاس الشريحة الرابعة
            return new Onboarding4();
        }
    }


    @Override
    public int getItemCount() {
        return layouts.length;
    }
}
