package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; // تأكد من استيراد Button إذا كان لديك زر

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {

    // (باقي المتغيرات ودوال newInstance و onCreate تبقى كما هي)
    // ...
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public SignupFragment() {
        // Required empty public constructor
    }

    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    // ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    // **********************************************
    // 1. إضافة دالة onViewCreated للوصول إلى عناصر الواجهة (Views)
    // **********************************************
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // هنا نفترض أن زر التسجيل (Sign Up) له ID هو 'signup_button'
        Button signupButton = view.findViewById(R.id.signup_button); // تأكد من استخدام الـ ID الصحيح

        if (signupButton != null) {
            signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // *** 2. هنا يجب أن تضع منطق التحقق من التسجيل الناجح ***
                    // ... (مثلاً، التحقق من الإيميل وكلمة المرور وتخزين البيانات)

                    // إذا كان التسجيل ناجحاً:
                    goToHomeScreen();
                }
            });
        }
    }

    // **********************************************
    // 3. الدالة المسؤولة عن الانتقال إلى واجهة الهوم وحذف الشاشات السابقة
    // **********************************************
    private void goToHomeScreen() {
        // التحقق من أن الـ Fragment مرتبط بـ Activity قبل محاولة الانتقال
        if (getActivity() != null) {

            // إنشاء Intent للانتقال إلى HomeActivity
            Intent intent = new Intent(getActivity(), HomeActivity.class);

            // إضافة علامات (Flags) لمسح جميع الأنشطة السابقة
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // بدء الـ Activity الجديد
            startActivity(intent);

            // إنهاء الـ Activity الحامل لهذا الـ Fragment (مثل AuthActivity أو LoginActivity)
            getActivity().finish();
        }
    }
}