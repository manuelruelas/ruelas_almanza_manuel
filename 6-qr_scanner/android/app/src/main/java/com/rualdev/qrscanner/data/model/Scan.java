package com.rualdev.qrscanner.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scans")
public class Scan {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String data;

    public Scan(String data) {
        this.data = data;
    }


}
