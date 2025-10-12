package com.example.finalproject;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecordAdapter adapter;
    private List<RecordModel> recordList;
    private Button btnAddRecord;

    public RecordsFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_records, container, false);

        recyclerView = view.findViewById(R.id.recyclerRecords);
        btnAddRecord = view.findViewById(R.id.btnAddRecord);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recordList = RecordStorage.getRecords();
        adapter = new RecordAdapter(recordList);
        recyclerView.setAdapter(adapter);

        btnAddRecord.setOnClickListener(v -> showAddRecordDialog());

        return view;
    }

    private void showAddRecordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_record, null);
        builder.setView(dialogView);

        EditText edtDoctor = dialogView.findViewById(R.id.edtDoctor);
        EditText edtDate = dialogView.findViewById(R.id.edtDate);
        EditText edtDiagnosis = dialogView.findViewById(R.id.edtDiagnosis);
        EditText edtTreatment = dialogView.findViewById(R.id.edtTreatment);
        Button btnSave = dialogView.findViewById(R.id.btnSave);

        AlertDialog dialog = builder.create();
        dialog.show();

        btnSave.setOnClickListener(v -> {
            String doctor = edtDoctor.getText().toString();
            String date = edtDate.getText().toString();
            String diagnosis = edtDiagnosis.getText().toString();
            String treatment = edtTreatment.getText().toString();

            if (!doctor.isEmpty() && !date.isEmpty()) {
                RecordModel record = new RecordModel(doctor, date, diagnosis, treatment);
                RecordStorage.addRecord(record);
                adapter.updateRecords(RecordStorage.getRecords());
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.updateRecords(RecordStorage.getRecords());
    }
}
