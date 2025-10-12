package com.example.finalproject;

public class RecordModel {
    private String doctorName;
    private String date;
    private String diagnosis;
    private String treatment;

    public RecordModel(String doctorName, String date, String diagnosis, String treatment) {
        this.doctorName = doctorName;
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDate() {
        return date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
}
