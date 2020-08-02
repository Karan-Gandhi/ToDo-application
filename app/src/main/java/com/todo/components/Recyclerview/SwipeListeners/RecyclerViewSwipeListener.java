package com.todo.components.Recyclerview.SwipeListeners;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarCallback;
import com.todo.components.FloatingCafebar;

import java.util.ArrayList;

public class RecyclerViewSwipeListener extends ItemTouchHelper.SimpleCallback {
    private String recentlyDeletedItem;
    private ArrayList<String> recyclerViewDataset;
    private Context context;
    private RecyclerView.Adapter recyclerViewAdapter;

    public RecyclerViewSwipeListener(int dragDirs, int swipeDirs, ArrayList<String> recyclerViewDataset, RecyclerView.Adapter recyclerViewAdapter, Context context) {
        super(dragDirs, swipeDirs);

        this.recyclerViewDataset = recyclerViewDataset;
        this.recyclerViewAdapter = recyclerViewAdapter;
        this.context = context;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        recentlyDeletedItem = recyclerViewDataset.get(position);
        recyclerViewDataset.remove(position);
        recyclerViewAdapter.notifyItemRemoved(position);
        showUndoSnackbar(viewHolder.itemView, position);
    }

    private void showUndoSnackbar(View view, final int position) {
        FloatingCafebar floatingCafebar = new FloatingCafebar(context, "Undo deleted Item", "Undo", Color.WHITE, Color.parseColor("#8cb0eb"));

        CafeBar cafeBar = floatingCafebar.build();

        cafeBar.setAction("Undo", Color.parseColor("#8cb0eb"), new CafeBarCallback() {
            @Override
            public void OnClick(@NonNull CafeBar CafeBarCallback) {
                undoDelete(position);
                cafeBar.dismiss();
            }
        });
        cafeBar.show();
    }

    private void undoDelete(int position) {
        recyclerViewDataset.add(position, recentlyDeletedItem);
        recyclerViewAdapter.notifyItemChanged(position);
    }
}
