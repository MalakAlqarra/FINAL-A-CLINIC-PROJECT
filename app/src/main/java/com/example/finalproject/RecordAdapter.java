package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.RecordModel;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<RecordModel> records;

    public RecordAdapter(List<RecordModel> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecordModel record = records.get(position);
        holder.txtDoctor.setText("Doctor: " + record.getDoctorName());
        holder.txtDate.setText("Date: " + record.getDate());
        holder.txtDiagnosis.setText("Diagnosis: " + record.getDiagnosis());
        holder.txtTreatment.setText("Treatment: " + record.getTreatment());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public void updateRecords(List<RecordModel> newList) {
        this.records = newList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDoctor, txtDate, txtDiagnosis, txtTreatment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDoctor = itemView.findViewById(R.id.txtDoctor);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtDiagnosis = itemView.findViewById(R.id.txtDiagnosis);
            txtTreatment = itemView.findViewById(R.id.txtTreatment);
        }
    }
}
