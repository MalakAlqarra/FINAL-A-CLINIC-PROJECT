package com.example.finalproject;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

            DatePickerDialog datePicker = new DatePickerDialog(context,
                    (view, year, month, dayOfMonth) -> {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;

                        TimePickerDialog timePicker = new TimePickerDialog(context,
                                (timeView, hourOfDay, minute) -> {
                                    String selectedTime = hourOfDay + ":" +
                                            String.format("%02d", minute);

                                    AppointmentModel appointment = new AppointmentModel(
                                            doctor.getName(),
                                            doctor.getSpecialty(),
                                            selectedDate,
                                            selectedTime
                                    );

                                    com.example.finalproject.AppointmentStorage.addAppointment(appointment);


                                    Calendar appointmentCalendar = Calendar.getInstance();
                                    appointmentCalendar.set(year, month, dayOfMonth, hourOfDay, minute, 0);
                                    long appointmentTimeMillis = appointmentCalendar.getTimeInMillis();

                                    scheduleAppointmentReminder(context, appointmentTimeMillis, doctor.getName());

                                    // ----------------------------------------------------

                                    Toast.makeText(context, "تم الحجز مع " +
                                            doctor.getName() + " وتم جدولة تذكير.", Toast.LENGTH_SHORT).show();

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


    private void scheduleAppointmentReminder(Context context, long appointmentTimeMillis, String doctorName) {

        // وقت التذكير: ساعة واحدة (3,600,000 مللي ثانية) قبل الموعد
        long oneHourBefore = appointmentTimeMillis - (60 * 60 * 1000);

        // **التأكد من أننا لم نتجاوز وقت التذكير بعد**
        if (oneHourBefore <= System.currentTimeMillis()) {
            return;
        }

        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("APPOINTMENT_TITLE", doctorName);

        int uniqueRequestCode = (int) (appointmentTimeMillis / 1000);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                uniqueRequestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            // setExactAndAllowWhileIdle
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    oneHourBefore,
                    pendingIntent
            );
        } else {
            // setExact للأجهزة القديمة
            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    oneHourBefore,
                    pendingIntent
            );
        }
    }
}