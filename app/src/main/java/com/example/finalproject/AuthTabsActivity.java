package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
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

        // 1. استلام نوع المستخدم (طبيب أو مريض) من شاشة الترحيب
        boolean isDoctor = getIntent().getBooleanExtra("is_doctor", false);
        Log.d("AuthTabs", "User Type: " + (isDoctor ? "Doctor" : "Patient"));
        // يمكنك استخدام isDoctor لاحقاً لتغيير حقول التسجيل/الدخول إذا لزم الأمر

        // 2. تعريف المكونات من XML
        viewPager = findViewById(R.id.view_pager_auth);
        tabLayout = findViewById(R.id.tab_layout);

        // 3. تهيئة الـ Adapter وربطه بـ ViewPager
        AuthPagerAdapter adapter = new AuthPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // 4. ربط الـ TabLayout بـ ViewPager2
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

