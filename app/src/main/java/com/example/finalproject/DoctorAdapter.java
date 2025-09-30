package com.example.finalproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.AppointmentModel;
import com.example.finalproject.DoctorModel;
import com.example.finalproject.R;

import java.util.Calendar;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    private List<DoctorModel> doctors;
    private Context context;

    public DoctorAdapter(List<DoctorModel> doctors, Context context) {
        this.doctors = doctors;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doctor_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DoctorModel doctor = doctors.get(position);
        holder.txtName.setText(doctor.getName());
        holder.txtSpecialty.setText(doctor.getSpecialty());
        holder.txtDays.setText("Days: " + doctor.getDays());
        holder.txtHours.setText("Hours: " + doctor.getHours());

        holder.btnBook.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();

            // أولاً: اختيار التاريخ
            DatePickerDialog datePicker = new DatePickerDialog(context,
                    (view, year, month, dayOfMonth) -> {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                        // ثانياً: اختيار الوقت
                        TimePickerDialog timePicker = new TimePickerDialog(context,
                                (timeView, hourOfDay, minute) -> {
                                    String selectedTime = hourOfDay + ":" +
                                            String.format("%02d", minute);

                                    // إنشاء الموعد
                                    AppointmentModel appointment = new AppointmentModel(
                                            doctor.getName(),
                                            doctor.getSpecialty(),
                                            selectedDate,
                                            selectedTime
                                    );

                                    // حفظ الموعد
                                    com.example.finalproject.AppointmentStorage.addAppointment(appointment);

                                    Toast.makeText(context, "تم الحجز مع " +
                                            doctor.getName(), Toast.LENGTH_SHORT).show();

                                }, calendar.get(Calendar.HOUR_OF_DAY),
                                calendar.get(Calendar.MINUTE),
                                true);
                        timePicker.show();

                    }, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            datePicker.show();
        });
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtSpecialty, txtDays, txtHours;
        Button btnBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtSpecialty = itemView.findViewById(R.id.txtSpecialty);
            txtDays = itemView.findViewById(R.id.txtDays);
            txtHours = itemView.findViewById(R.id.txtHours);
            btnBook = itemView.findViewById(R.id.btnBook);
        }
    }
}
