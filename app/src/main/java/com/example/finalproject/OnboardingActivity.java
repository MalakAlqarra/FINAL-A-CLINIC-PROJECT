package com.example.finalproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.view_pager);
        TextView skipTextView = findViewById(R.id.skip_text);
        Button nextButton = findViewById(R.id.next_button);

        int[] layouts = new int[]{
                R.layout.onboarding_page1,
                R.layout.onboarding_page2,
                R.layout.onboarding_page3,
                R.layout.onboarding_page4
        };

        OnboardingAdapter adapter = new OnboardingAdapter(this, layouts);
        viewPager.setAdapter(adapter);

        skipTextView.setOnClickListener(v -> {
            navigateToAuthScreen();
        });

        nextButton.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem < layouts.length - 1) {
                viewPager.setCurrentItem(currentItem + 1);
            } else {
                navigateToAuthScreen();
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int lastPage = layouts.length - 1;

                if (position == lastPage) {
                    skipTextView.setVisibility(View.GONE);
                    nextButton.setVisibility(View.GONE);
                } else {
                    skipTextView.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void navigateToAuthScreen() {
        // يجب الانتقال إلى شاشة AuthWelcomeActivity التي تسبق AuthTabsActivity
        Intent intent = new Intent(OnboardingActivity.this, AuthWelcomeActivity.class); // 👈 تم التصحيح
        startActivity(intent);
        finish();
    }
}