package com.example.finalproject;

public class DoctorModel {
    private String name;
    private String specialty;
    private String days;
    private String hours;

    public DoctorModel(String name, String specialty, String days, String hours) {
        this.name = name;
        this.specialty = specialty;
        this.days = days;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getDays() {
        return days;
    }

    public String getHours() {
        return hours;
    }
}
