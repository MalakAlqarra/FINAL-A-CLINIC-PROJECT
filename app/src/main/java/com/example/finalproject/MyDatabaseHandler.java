package com.example.finalproject;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// هذا الكود يمكن وضعه في أي Activity أو Fragment
// حيث تحتاج لتنفيذ عملية قاعدة بيانات
public class MyDatabaseHandler {
    // ExecutorService هو تجمع للخيوط لتنفيذ المهام
    // Executors.newSingleThreadExecutor() يضمن أن مهمة واحدة فقط ستعمل في أي وقت
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    // Handler هو الذي يسمح لك بإرسال المهام إلى واجهة المستخدم الرئيسية (UI Thread)
    private final Handler handler = new Handler(Looper.getMainLooper());

    // هذه الدالة العامة التي ستستخدمها لتنفيذ أي عملية قاعدة بيانات
    public void executeDbOperation(Runnable dbTask, Runnable uiTask) {
        // نرسل المهمة التي تتعامل مع قاعدة البيانات إلى الخيط في الخلفية
        executorService.execute(() -> {
            // المهمة التي يجب أن تتم في الخلفية (مثلاً: userDao.insertUser())
            dbTask.run();

            // بعد الانتهاء، نرسل المهمة لتحديث واجهة المستخدم الرئيسية
            handler.post(uiTask);
        });
    }
}

