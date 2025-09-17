package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "userId",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE))
public class Doctor {

    @PrimaryKey(autoGenerate = true)
    public int doctorId;

    @ColumnInfo(name = "userId")
    public int userId;

    @ColumnInfo(name = "specialty")
    public String specialty;

    @ColumnInfo(name = "bio")
    public String bio;

    // constructor
    public Doctor(int userId, String specialty, String bio) {
        this.userId = userId;
        this.specialty = specialty;
        this.bio = bio;
    }

    // Getters and setters for all fields
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
