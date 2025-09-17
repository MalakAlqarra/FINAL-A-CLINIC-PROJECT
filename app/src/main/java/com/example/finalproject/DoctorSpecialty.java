package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "specialties")
public class DoctorSpecialty {

    @PrimaryKey(autoGenerate = true)
    public int specialtyId;

    @ColumnInfo(name = "specialtyName")
    public String specialtyName;

    // constructor
    public DoctorSpecialty(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    // Getters
    public int getSpecialtyId() { return specialtyId; }
    public String getSpecialtyName() { return specialtyName; }

    // Setters
    public void setSpecialtyId(int specialtyId) { this.specialtyId = specialtyId; }
    public void setSpecialtyName(String specialtyName) { this.specialtyName = specialtyName; }
}