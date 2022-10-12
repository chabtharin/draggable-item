package com.chabtharin.draggableitem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chabtharin.draggableitem.R;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class DraggableAdapter extends RecyclerView.Adapter<DraggableAdapter.DraggableViewHolder> {
    private final List<String> mDataSet;
    public DraggableAdapter(List<String> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @NonNull
    @Override
    public DraggableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_item, parent, false);
        Animation animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.shake);
        view.startAnimation(animation);
        Executors.newSingleThreadScheduledExecutor().schedule(() ->
            view.clearAnimation()
        , 1000, TimeUnit.MILLISECONDS);
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
