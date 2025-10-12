package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;
import android.util.Log;

public class AuthTabsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_tabs);


        boolean isDoctor = getIntent().getBooleanExtra("is_doctor", false);
        Log.d("AuthTabs", "User Type: " + (isDoctor ? "Doctor" : "Patient"));

        viewPager = findViewById(R.id.view_pager_auth);
        tabLayout = findViewById(R.id.tab_layout);

//        AuthPagerAdapter adapter = new AuthPagerAdapter(this);
//        viewPager.setAdapter(adapter);

        // TabLayoutMediator يتولى مهمة تزامن الـ Tabs مع الصفحات
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("LOGIN");
                    } else {
                        tab.setText("SIGN UP");
                    }
                }
        ).attach();

    }
}

