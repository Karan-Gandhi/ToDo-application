package com.todo.components.Recyclerview.Adapters;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.todo.R;
import com.todo.Animator.RecyclerViewComponentAnimator;

import java.util.ArrayList;
import java.util.Arrays;

public class ToDoListRecyclerViewAdapter extends RecyclerView.Adapter<ToDoListRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> dataset;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public LinearLayout layoutRoot;
        public View removeIcon;
        public ImageView done;

        public AnimatedVectorDrawableCompat avd = null;
        public AnimatedVectorDrawable avd_ = null;
        public Drawable done_drawable;

        private RecyclerViewComponentAnimator animator;

        public ViewHolder(LinearLayout layout) {
            super(layout);
            this.layoutRoot = layout;
            this.title = (TextView) layout.findViewById(R.id.todo_task_title);
            this.removeIcon = layout.findViewById(R.id.remove_icon);
            this.done = (ImageView) layout.findViewById(R.id.tick_animation_vector_image);
            this.done_drawable = done.getDrawable();

            if (done_drawable instanceof AnimatedVectorDrawableCompat) {
                avd = (AnimatedVectorDrawableCompat) done_drawable;
            } else if (done_drawable instanceof AnimatedVectorDrawable) {
                avd_ = (AnimatedVectorDrawable) done_drawable;
            }

            animator = new RecyclerViewComponentAnimator(this);
        }

        public void setTitleText(String task) {
            this.title.setText(task);
        }

        public ViewHolder setOnclickListener() {
            this.layoutRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animator.animate();
                }
            });
            return this;
        }
    }

    public ToDoListRecyclerViewAdapter(String[] dataset) {
        this.dataset = new ArrayList<String>(Arrays.asList(dataset));
    }

    public ToDoListRecyclerViewAdapter(ArrayList<String> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_todo_list_wiget, parent, false);
        return new ViewHolder(layout).setOnclickListener();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setTitleText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
