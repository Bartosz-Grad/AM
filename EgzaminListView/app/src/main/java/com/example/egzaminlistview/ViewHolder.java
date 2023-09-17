package com.example.egzaminlistview;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;

    public ViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.item_title);
    }
}
