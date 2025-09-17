package com.example.finalproject;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Doctor.class, Appointment.class, MedicalRecord.class, DoctorSpecialty.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract DoctorDao doctorDao();
    public abstract AppointmentDao appointmentDao();
    public abstract MedicalRecordDao medicalRecordDao();
    public abstract SpecialtyDao specialtyDao();

    private static volatile AppDatabase INSTANCE;

    // Singleton pattern
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "clinic_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

