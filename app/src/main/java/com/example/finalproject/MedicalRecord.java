package com.example.finalproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "medical_records",
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
public class MedicalRecord {

    @PrimaryKey(autoGenerate = true)
    public int recordId;

    @ColumnInfo(name = "patientId")
    public int patientId;

    @ColumnInfo(name = "doctorId")
    public int doctorId;

    @ColumnInfo(name = "visitDate")
    public String visitDate;

    @ColumnInfo(name = "notes")
    public String notes;

    @ColumnInfo(name = "prescription")
    public String prescription;

    // constructor
    public MedicalRecord(int patientId, int doctorId, String visitDate, String notes, String prescription) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.notes = notes;
        this.prescription = prescription;
    }

    // Getters
    public int getRecordId() { return recordId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getVisitDate() { return visitDate; }
    public String getNotes() { return notes; }
    public String getPrescription() { return prescription; }

    // Setters
    public void setRecordId(int recordId) { this.recordId = recordId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setPrescription(String prescription) { this.prescription = prescription; }
}