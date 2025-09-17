package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface AppointmentDao {

    @Insert
    void insertAppointment(Appointment appointment);

    @Update
    void updateAppointment(Appointment appointment);

    @Delete
    void deleteAppointment(Appointment appointment);

    @Query("SELECT * FROM appointments WHERE patientId = :patientId ORDER BY appointmentDate ASC")
    List<Appointment> getAppointmentsForPatient(int patientId);

    @Query("SELECT * FROM appointments WHERE doctorId = :doctorId ORDER BY appointmentDate ASC")
    List<Appointment> getAppointmentsForDoctor(int doctorId);

    @Query("SELECT * FROM appointments WHERE doctorId = :doctorId AND appointmentDate = :date AND status = 'confirmed'")
    List<Appointment> getConfirmedAppointmentsForDoctorOnDate(int doctorId, String date);

    @Query("SELECT * FROM appointments WHERE appointmentId = :appointmentId")
    Appointment getAppointmentById(int appointmentId);
}
