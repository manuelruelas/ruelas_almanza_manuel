package com.rualdev.qrscanner.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rualdev.qrscanner.data.model.Scan;

import java.util.List;

@Dao
public interface ScanDao {
    @Insert
    void insert(Scan scan);

    @Query("SELECT * FROM scans")
    LiveData<List<Scan>> getAllScans();
}