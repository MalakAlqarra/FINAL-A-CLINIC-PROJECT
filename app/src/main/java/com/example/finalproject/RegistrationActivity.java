//package com.example.finalproject;
//
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//// في شاشة التسجيل (RegistrationActivity.java)
//public class RegistrationActivity extends AppCompatActivity {
//
//    private MyDatabaseHandler dbHandler;
//    private UserDao userDao;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // ... (إعداد واجهة المستخدم)
//
//        // إعداد الكلاسات التي سنستخدمها
//        dbHandler = new MyDatabaseHandler();
//        userDao = AppDatabase.getInstance(this).userDao();
//
//        Button registerButton = findViewById(R.id.register_btn);
//        registerButton.setOnClickListener(v -> registerUser());
//    }
//
//    private void registerUser() {
//        // 1. احصل على بيانات المستخدم
//        String name = "اسم المستخدم";
//        String email = "example@mail.com";
//        String password = "hashed_password";
//        String role = "patient";
//
//        // 2. أنشئ كائن المستخدم
//        User newUser = new User(name, email, password, role);
//
//        // 3. ابدأ عملية قاعدة البيانات في الخلفية
//        dbHandler.executeDbOperation(
//                // المهمة الأولى: حفظ المستخدم في قاعدة البيانات
//                () -> userDao.insertUser(newUser),
//
//                // المهمة الثانية: عرض رسالة للمستخدم بعد نجاح العملية
//                () -> Toast.makeText(this, "تم التسجيل بنجاح", Toast.LENGTH_SHORT).show()
//        );
//    }
//}