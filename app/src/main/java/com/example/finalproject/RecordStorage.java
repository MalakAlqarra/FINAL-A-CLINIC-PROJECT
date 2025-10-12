package com.example.finalproject;

import com.example.finalproject.RecordModel;

import java.util.ArrayList;
import java.util.List;

public class RecordStorage {
    private static List<RecordModel> records = new ArrayList<>();

    public static void addRecord(RecordModel record) {
        records.add(record);
    }

    public static List<RecordModel> getRecords() {
        return records;
    }
}
