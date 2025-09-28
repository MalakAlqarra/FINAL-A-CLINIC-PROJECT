package com.example.finalproject;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.finalproject.OnboardingAdapter;

// imports أخرى تحتاجها
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnboardingFragment extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TextView skipTextView;
    private Button nextButton;

    public OnboardingFragment(int layout) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.view_pager);
        skipTextView = findViewById(R.id.skip_text);
        nextButton = findViewById(R.id.next_button);

        // مصفوفة تحتوي على كل ملفات الـ Layout
        int[] layouts = new int[]{
                R.layout.onboarding_page1,
                R.layout.onboarding_page2,
                R.layout.onboarding_page3,
                R.layout.onboarding_page4 // نضيف هنا الصفحة الأخيرة
        };

        // تهيئة الـ Adapter وربطه بالـ ViewPager
        OnboardingAdapter adapter = new OnboardingAdapter(this, layouts);
        viewPager.setAdapter(adapter);


        // منطق زر التخطي
        skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // الانتقال إلى شاشة تسجيل الدخول
                // يمكنك إنشاء Activity لهذا الغرض
            }
        });

        // منطق زر Next للتنقل بين الصفحات
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() < layouts.length - 1) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
    }
}