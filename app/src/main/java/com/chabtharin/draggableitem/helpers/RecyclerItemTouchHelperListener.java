package com.chabtharin.draggableitem.helpers;

import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);

    boolean onItemMove(int fromPosition, int toPosition);
}
