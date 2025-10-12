package com.example.finalproject;

import com.example.finalproject.AppointmentModel;

import java.util.ArrayList;
import java.util.List;

public class AppointmentStorage {
    private static List<AppointmentModel> appointments = new ArrayList<>();

    public static void addAppointment(AppointmentModel appointment) {
        appointments.add(appointment);
    }

    public static List<AppointmentModel> getAppointments() {
        return appointments;
    }
}
