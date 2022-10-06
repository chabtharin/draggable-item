package com.chabtharin.draggableitem.helpers;

import android.graphics.Canvas;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.view.View;

import com.chabtharin.draggableitem.adapter.DraggableAdapter;

public class RecyclerTouchHelper extends ItemTouchHelper.SimpleCallback {

    RecyclerItemTouchHelperListener recyclerItemTouchHelperListener;

    public RecyclerTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener recyclerItemTouchHelperListener) {
        super(dragDirs, swipeDirs);
        this.recyclerItemTouchHelperListener = recyclerItemTouchHelperListener;
    }

    /*@Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }*/

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }

        recyclerItemTouchHelperListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            recyclerItemTouchHelperListener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
        }
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            final View foregroundView = ((DraggableAdapter.DraggableViewHolder) viewHolder).itemView;
            getDefaultUIUtil().onSelected(foregroundView);
        }

//        if (viewHolder instanceof DragRecyclerAdapter.ViewHolder) {
//            final View foregroundView = ((DragRecyclerAdapter.ViewHolder) viewHolder).rel_foreground;
//            getDefaultUIUtil().onSelected(foregroundView);
//        }
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder
            viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            final View foregroundView = ((DraggableAdapter.DraggableViewHolder) viewHolder).itemView;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY,
                    actionState, isCurrentlyActive);
        }

        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            final View foregroundView = ((DraggableAdapter.DraggableViewHolder) viewHolder).itemView;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY,
                    actionState, isCurrentlyActive);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            final View foregroundView = ((DraggableAdapter.DraggableViewHolder) viewHolder).itemView;
            getDefaultUIUtil().clearView(foregroundView);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder
            viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (viewHolder instanceof DraggableAdapter.DraggableViewHolder) {
            View foregroundView = ((DraggableAdapter.DraggableViewHolder) viewHolder).itemView;
            getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY,
                    actionState, isCurrentlyActive);
        }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }
}
