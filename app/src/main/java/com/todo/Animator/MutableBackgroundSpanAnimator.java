package com.todo.Animator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.SpannableString;
import android.widget.TextView;

import com.todo.components.MutableBackgroundSpan;

public class MutableBackgroundSpanAnimator<T extends TextView> {
    private MutableBackgroundSpan span;
    private SpannableString ss;
    private T view;

    public MutableBackgroundSpanAnimator(MutableBackgroundSpan span, SpannableString ss, T view) {
        this.span = span;
        this.ss = ss;
        this.view = view;
    }

    public void start() {
        ObjectAnimator animator = ObjectAnimator.ofInt(span, MutableBackgroundSpan.MUTABLE_BACKGROUND_SPAN_INTEGER_PROPERTY, Color.WHITE, Color.BLUE);
        animator.setDuration(1000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setText(ss);
            }
        });
        animator.start();
    }
}
