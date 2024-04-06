package com.rualdev.qrscanner.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.rualdev.qrscanner.data.database.AppDatabase;
import com.rualdev.qrscanner.data.database.dao.ScanDao;
import com.rualdev.qrscanner.data.model.Scan;

import java.util.List;

public class ScanRepository {
    private ScanDao scanDao;

    public ScanRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        scanDao = database.scanDao();
    }

    public void insert(Scan scan) {
        new InsertAsyncTask(scanDao).execute(scan);
    }

    public LiveData<List<Scan>> getAllScans() {
        return scanDao.getAllScans();
    }

    private static class InsertAsyncTask extends AsyncTask<Scan, Void, Void> {
        private ScanDao scanDao;

        InsertAsyncTask(ScanDao scanDao) {
            this.scanDao = scanDao;
        }

        @Override
        protected Void doInBackground(Scan... scans) {
            scanDao.insert(scans[0]);
            return null;
        }
    }
}