package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    void insertDoctor(Doctor doctor);

    @Update
    void updateDoctor(Doctor doctor);

    @Query("SELECT * FROM doctors WHERE doctorId = :doctorId")
    Doctor getDoctorById(int doctorId);

    @Query("SELECT * FROM doctors WHERE specialty = :specialty")
    List<Doctor> getDoctorsBySpecialty(String specialty);

    @Query("SELECT * FROM doctors")
    List<Doctor> getAllDoctors();
}
