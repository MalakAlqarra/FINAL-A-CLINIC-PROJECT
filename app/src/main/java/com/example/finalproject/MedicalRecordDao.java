package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface MedicalRecordDao {

    @Insert
    void insertMedicalRecord(MedicalRecord record);

    @Update
    void updateMedicalRecord(MedicalRecord record);

    @Delete
    void deleteMedicalRecord(MedicalRecord record);

    @Query("SELECT * FROM medical_records WHERE patientId = :patientId ORDER BY visitDate DESC")
    List<MedicalRecord> getMedicalRecordsForPatient(int patientId);

    @Query("SELECT * FROM medical_records WHERE doctorId = :doctorId")
    List<MedicalRecord> getMedicalRecordsByDoctor(int doctorId);
}
