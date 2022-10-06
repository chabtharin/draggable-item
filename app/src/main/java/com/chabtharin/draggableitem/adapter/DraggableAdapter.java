package com.chabtharin.draggableitem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chabtharin.draggableitem.R;

import java.util.List;

public class DraggableAdapter extends RecyclerView.Adapter<DraggableAdapter.DraggableViewHolder> {
    private final List<String> mDataSet;

    public DraggableAdapter(List<String> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public DraggableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_item, parent, false);
        return new DraggableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DraggableViewHolder holder, int position) {
        holder.tvTitle.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class DraggableViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final ImageView ivIcon;
        public DraggableViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
