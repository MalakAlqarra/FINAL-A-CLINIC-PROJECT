package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class onboarding_page2 extends Fragment {

    public onboarding_page2() {
        // مطلوب للبناء الافتراضي
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // 🚨 هنا يتم ربط ملف التصميم الأول
        return inflater.inflate(R.layout.onboarding_page2, container, false);
    }
}