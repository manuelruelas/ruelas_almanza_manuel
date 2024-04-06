package com.rualdev.qrscanner.ui.view.scanList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rualdev.qrscanner.R;
import com.rualdev.qrscanner.data.model.Scan;

import java.util.ArrayList;
import java.util.List;

public class ScanAdapter extends RecyclerView.Adapter<ScanAdapter.ScanViewHolder> {

    private List<Scan> scanList = new ArrayList<>();

    private Context context;
    public ScanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ScanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scan_item, parent, false);
        return new ScanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScanViewHolder holder, int position) {
        Scan scanData = scanList.get(position);
        holder.bind(scanData);
    }

    @Override
    public int getItemCount() {
        return scanList.size();
    }

    public void setScanList(List<Scan> scanList) {
        this.scanList = scanList;
        notifyDataSetChanged();
    }

    public class ScanViewHolder extends RecyclerView.ViewHolder {

        private TextView scanDataTextView;

        public ScanViewHolder(@NonNull View itemView) {
            super(itemView);
            scanDataTextView = itemView.findViewById(R.id.scanDataTextView);
        }

        public void bind(Scan scanData) {
            scanDataTextView.setText(scanData.data);
        }
    }
}
