package com.example.finalproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // ... (باقي المتغيرات مثل drawerLayout)

    // المتغيرات الجديدة للـ Tabs
    private TabLayout tabLayout;
    private ViewPager2 viewPagerTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // ... (إعداد الـ Toolbar والـ Drawer كما كان سابقاً)

        // ------------------------- إعداد التبويبات (Tabs) -------------------------
        tabLayout = findViewById(R.id.tab_layout);
        viewPagerTabs = findViewById(R.id.view_pager_home_tabs);

        // 1. إعداد الـ Adapter للـ Tabs
        HomeTabsAdapter tabsAdapter = new HomeTabsAdapter(getSupportFragmentManager(), getLifecycle());
        viewPagerTabs.setAdapter(tabsAdapter);

        // 2. ربط الـ TabLayout بالـ ViewPager2 وتعيين العناوين
        String[] titles = {"Doctor", "Appointments", "Hospital", "records"};
        new TabLayoutMediator(tabLayout, viewPagerTabs,
                (tab, position) -> {
                    tab.setText(titles[position]);
                    // يمكنك إضافة الأيقونات هنا إذا لزم الأمر
                    // tab.setIcon(R.drawable.ic_icon_for_tab);
                }
        ).attach();

        // --------------------------------------------------------------------------

        // ... (إعداد الـ Bottom Navigation وباقي منطق الـ Activity)

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    // ... (باقي دوال الـ Activity مثل navListener و onNavigationItemSelected)
}