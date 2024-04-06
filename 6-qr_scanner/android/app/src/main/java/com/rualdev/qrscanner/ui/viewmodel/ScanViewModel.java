package com.rualdev.qrscanner.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rualdev.qrscanner.data.model.Scan;
import com.rualdev.qrscanner.data.repository.ScanRepository;

import java.util.List;

public class ScanViewModel extends AndroidViewModel {
    private ScanRepository repository;
    private LiveData<List<Scan>> allScans;

    public ScanViewModel(@NonNull Application application) {
        super(application);
        repository = new ScanRepository(application);
        allScans = repository.getAllScans();
    }

    public void insert(Scan scan) {
        repository.insert(scan);
    }

    public LiveData<List<Scan>> getAllScans() {
        return allScans;
    }
}
