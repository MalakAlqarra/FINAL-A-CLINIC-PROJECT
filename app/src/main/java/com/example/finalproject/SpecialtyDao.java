package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface SpecialtyDao {

    @Insert
    void insertSpecialty(DoctorSpecialty specialty);

    @Query("SELECT * FROM specialties")
    List<DoctorSpecialty> getAllSpecialties();

    @Query("SELECT * FROM specialties WHERE specialtyId = :specialtyId")
    DoctorSpecialty getSpecialtyById(int specialtyId);

    @Query("SELECT * FROM specialties WHERE specialtyName = :specialtyName")
    DoctorSpecialty getSpecialtyByName(String specialtyName);
}
