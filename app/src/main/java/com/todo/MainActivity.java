package com.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.todo.Recyclerview.Adapters.ToDoListRecyclerViewAdapter;
import com.todo.Recyclerview.SwipeListeners.RecyclerViewSwipeListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter todo_adapter;
    private RecyclerView.LayoutManager todo_layoutManager;
    private ArrayList<String> todoRecyclerViewDataset = new ArrayList<>(Arrays.asList(new String[]{"Task 1", "Taks 2", "Task 3", "Task 4"}));

    private final int MIN_CAFEBAR_WIDTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        createRecyclerView();
    }

    public void createRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.todo_tasks_list);

        recyclerView.hasFixedSize();
        todo_layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(todo_layoutManager);
        todo_adapter = new ToDoListRecyclerViewAdapter(todoRecyclerViewDataset);
        recyclerView.setAdapter(todo_adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ItemTouchHelper.SimpleCallback recyclerViewSwipeListenerCallback = new RecyclerViewSwipeListener(0, ItemTouchHelper.LEFT, todoRecyclerViewDataset, todo_adapter, MainActivity.this);
        new ItemTouchHelper(recyclerViewSwipeListenerCallback).attachToRecyclerView(recyclerView);
    }
}