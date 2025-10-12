package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private List<AppointmentModel> appointments;

    public AppointmentAdapter(List<AppointmentModel> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppointmentModel appointment = appointments.get(position);
        holder.txtDoctor.setText(appointment.getDoctorName());
        holder.txtSpecialty.setText(appointment.getSpecialty());
        holder.txtDate.setText("Date: " + appointment.getDate());
        holder.txtTime.setText("Time: " + appointment.getTime());
        holder.txtStatus.setText("Status: " + appointment.getStatus());

    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void updateAppointments(List<AppointmentModel> newList) {
        this.appointments = newList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDoctor, txtSpecialty, txtDate, txtTime , txtStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDoctor = itemView.findViewById(R.id.txtDoctor);
            txtSpecialty = itemView.findViewById(R.id.txtSpecialty);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtStatus = itemView.findViewById(R.id.txtStatus);

        }
    }
}
