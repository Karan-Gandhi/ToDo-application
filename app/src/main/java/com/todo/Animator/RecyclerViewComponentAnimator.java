package com.todo.Animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.todo.components.RecyclerviewAdapters.ToDoListRecyclerViewAdapter;
import com.todo.components.RecyclerviewAdapters.ToDoListRecyclerViewAdapter;

public class RecyclerViewComponentAnimator {
    private ToDoListRecyclerViewAdapter.ViewHolder viewHolder;
    private boolean completed = false;

    public RecyclerViewComponentAnimator(ToDoListRecyclerViewAdapter.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    public void animate() {
        if (!completed) {
            // get the width of the textbox which we have to strike through
            viewHolder.title.measure(0 ,0);
            ViewGroup.LayoutParams params = viewHolder.removeIcon.getLayoutParams();
            params.width = viewHolder.title.getMeasuredWidth();
            int width = viewHolder.title.getMeasuredWidth() - 15;

            // create the animation
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(viewHolder.removeIcon, "translationX", 0f, 65f);
            ValueAnimator animatorW = ValueAnimator.ofFloat(0f, (float) width);

            animatorW.setDuration(600);
            animatorW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float progress = (float) valueAnimator.getAnimatedValue() + 30;
                    params.width = (int) progress;
                    viewHolder.removeIcon.setLayoutParams(params);
                }
            });

            animatorX.setDuration(600);
            animatorX.setInterpolator(new AccelerateDecelerateInterpolator());

            // start the animation
            animatorX.start();
            animatorW.start();

            if (viewHolder.avd != null) viewHolder.avd.start();
            else if (viewHolder.avd_ != null) viewHolder.avd_.start();
        } else {

        }
    }
}
