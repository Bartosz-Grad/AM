package com.example.egzaminlistview;
import android.widget.TextView;
import java.util.List;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<String> dataList;

    public Adapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.titleTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItem(String newItem) {
        dataList.add(newItem);
        notifyItemInserted(dataList.size() - 1);
    }
}
