package com.todo.Recyclerview.SwipeListeners;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarCallback;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.todo.MainActivity;
import com.todo.components.FloatingCafebar;

import java.util.ArrayList;

public class RecyclerViewSwipeListener extends ItemTouchHelper.SimpleCallback {
    private String recentlyDeletedItem;
    private ArrayList<String> recyclerViewDataset;
    private Context context;
    private RecyclerView.Adapter recyclerViewAdapter;

    private static final int MIN_CAFEBAR_WIDTH = 1000;

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
        FloatingCafebar floatingCafebar = new FloatingCafebar(context, "Undo deleted Item", "Undo", Color.WHITE, Color.WHITE);

        CafeBar cafeBar = floatingCafebar.build();

        cafeBar.setAction("Undo", Color.BLUE, new CafeBarCallback() {
            @Override
            public void OnClick(@NonNull CafeBar CafeBarCallback) {
                undoDelete(position);
                cafeBar.dismiss();
            }
        });

        View v = (LinearLayout) cafeBar.getView();
        v.setMinimumWidth(MIN_CAFEBAR_WIDTH);
        cafeBar.show();
    }

    private void undoDelete(int position) {
        recyclerViewDataset.add(position, recentlyDeletedItem);
        recyclerViewAdapter.notifyItemChanged(position);
    }
}
