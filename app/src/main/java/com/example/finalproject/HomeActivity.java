package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPagerTabs;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tab_layout);
        viewPagerTabs = findViewById(R.id.view_pager_home_tabs);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // ------------------ إعداد Tabs ------------------
        HomeTabsAdapter tabsAdapter = new HomeTabsAdapter(getSupportFragmentManager(), getLifecycle());
        viewPagerTabs.setAdapter(tabsAdapter);

        String[] titles = {"Doctor", "Appointments", "Hospital", "Records"};
        new TabLayoutMediator(tabLayout, viewPagerTabs,
                (tab, position) -> tab.setText(titles[position])
        ).attach();

        // ------------------ إعداد BottomNavigation ------------------
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_home) {

                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                // لا نحتاج لتبديل Fragment، فقط نفتح الـ Activity
                // لكن يجب أن نوقف التبديل إلى أي Fragment في هذه الحالة
                return true;

            } else if (id == R.id.nav_doctors) {
                selectedFragment = new BtnDoctorsFragment();
            } else if (id == R.id.nav_schedule) {
                selectedFragment = new BtnAppointmentsFragment();
            } else if (id == R.id.nav_profile) {
                selectedFragment = new BtnProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.home_fragment_container, selectedFragment)
                        .commit();
            }

            return true; // مهم جداً
        });



   //      ------------------ عرض أول Fragment عند البداية ------------------
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }
}
