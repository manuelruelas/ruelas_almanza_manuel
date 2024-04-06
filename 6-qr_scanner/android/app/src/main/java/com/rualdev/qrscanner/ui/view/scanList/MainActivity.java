package com.rualdev.qrscanner.ui.view.scanList;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.rualdev.qrscanner.R;
import com.rualdev.qrscanner.data.model.Scan;
import com.rualdev.qrscanner.ui.view.scanList.adapter.ScanAdapter;
import com.rualdev.qrscanner.ui.viewmodel.ScanViewModel;


import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ScanViewModel viewModel;
    private RecyclerView scanRecyclerView;
    private ScanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonScan = findViewById(R.id.scanButton);
        buttonScan.setOnClickListener(v -> startQRScanner());

        viewModel = new ViewModelProvider(this).get(ScanViewModel.class);

        scanRecyclerView = findViewById(R.id.scanRecyclerView);
        scanRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ScanAdapter(getApplicationContext());
        scanRecyclerView.setAdapter(adapter);
        viewModel.getAllScans().observe(this, scans -> {

            adapter.setScanList(scans);
        });

    }

    private void startQRScanner() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(true);
        integrator.setTimeout(10000);
        integrator.setPrompt("Scan a QR code");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                viewModel.insert(new Scan(result.getContents()));
                Toast.makeText(this, "Data: " + result.getContents(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }


}