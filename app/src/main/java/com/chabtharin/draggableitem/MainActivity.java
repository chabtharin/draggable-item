package com.chabtharin.draggableitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.chabtharin.draggableitem.adapter.DraggableAdapter;
import com.chabtharin.draggableitem.databinding.ActivityMainBinding;
import com.chabtharin.draggableitem.helpers.RecyclerItemTouchHelperListener;
import com.chabtharin.draggableitem.helpers.RecyclerTouchHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {
    private ActivityMainBinding binding;
    private List<String> mDataSet = new ArrayList<>();
    private DraggableAdapter draggableAdapter;
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
        draggableAdapter = new DraggableAdapter(mDataSet);
        binding.rcDraggable.setAdapter(draggableAdapter);
        binding.rcDraggable.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        ItemTouchHelper.SimpleCallback callback = new RecyclerTouchHelper(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.RIGHT | ItemTouchHelper.END, 0, this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.rcDraggable);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mDataSet, fromPosition, toPosition);
        draggableAdapter.notifyItemMoved(fromPosition, toPosition);
        return true;
    }
}