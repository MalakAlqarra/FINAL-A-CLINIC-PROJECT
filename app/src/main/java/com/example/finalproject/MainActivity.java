package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText nameEt, emailEt, passwordEt;
    private Button registerBtn;
    private UserDao userDao;
    private MyDatabaseHandler dbHandler; // الكلاس اللي أنشأناه

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // تهيئة الواجهة
        nameEt = findViewById(R.id.name_et);
        emailEt = findViewById(R.id.email_et);
        passwordEt = findViewById(R.id.password_et);
        registerBtn = findViewById(R.id.register_btn);

        // تهيئة قاعدة البيانات والـ Handler
        userDao = AppDatabase.getInstance(this).userDao();
        dbHandler = new MyDatabaseHandler();

        // إعداد زر التسجيل
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser() {
        // 1. الحصول على البيانات من المستخدم
        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        // 2. التحقق من أن الحقول ليست فارغة
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. إنشاء كائن المستخدم
        User newUser = new User(name, email, password, "patient");

        // 4. تنفيذ العملية في الخلفية
        dbHandler.executeDbOperation(
                // المهمة الأولى: حفظ المستخدم في قاعدة البيانات
                () -> {
                    userDao.insertUser(newUser);
                },
                // المهمة الثانية: إظهار رسالة للمستخدم
                () -> {
                    Toast.makeText(this, "User registered successfully!", Toast.LENGTH_SHORT).show();
                }

        );
    }
}

