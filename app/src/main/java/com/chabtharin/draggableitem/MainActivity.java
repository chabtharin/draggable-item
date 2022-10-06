package com.chabtharin.draggableitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.chabtharin.draggableitem.adapter.DraggableAdapter;
import com.chabtharin.draggableitem.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<String> mDataSet = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mDataSet.add("Report");
        mDataSet.add("Sale");
        mDataSet.add("Tea Time");
        mDataSet.add("Inventory");
        mDataSet.add("Masters");
        mDataSet.add("Users");
        DraggableAdapter draggableAdapter = new DraggableAdapter(mDataSet);
        binding.rcDraggable.setAdapter(draggableAdapter);
        binding.rcDraggable.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }
}