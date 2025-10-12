package com.example.finalproject;

public class AppointmentModel {
    private String doctorName;
    private String specialty;
    private String date;
    private String time;
    private String status; // Pending / Completed

    public AppointmentModel(String doctorName, String specialty, String date, String time) {
        this.doctorName = doctorName;
        this.specialty = specialty;
        this.date = date;
        this.time = time;
        this.status = "Pending";


    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
