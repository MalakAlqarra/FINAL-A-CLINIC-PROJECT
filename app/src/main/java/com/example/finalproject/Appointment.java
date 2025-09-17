package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "appointments",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "userId",
                        childColumns = "patientId",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Doctor.class,
                        parentColumns = "doctorId",
                        childColumns = "doctorId",
                        onDelete = ForeignKey.CASCADE)
        })
public class Appointment {

    @PrimaryKey(autoGenerate = true)
    public int appointmentId;

    @ColumnInfo(name = "patientId")
    public int patientId;

    @ColumnInfo(name = "doctorId")
    public int doctorId;

    @ColumnInfo(name = "appointmentDate")
    public String appointmentDate;

    @ColumnInfo(name = "appointmentTime")
    public String appointmentTime;

    @ColumnInfo(name = "status")
    public String status;

    public Appointment(int patientId, int doctorId, String appointmentDate, String appointmentTime, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Getters
    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}