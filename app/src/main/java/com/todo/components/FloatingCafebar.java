package com.todo.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarCallback;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.todo.R;

public class FloatingCafebar {
    private String title;
    private String actionText;
    private int textColor;
    private int actionColor;
    private CafeBar.Builder builder;
    private Context context;

    public CafeBar cafeBar;

    public FloatingCafebar(Context context, String title, String actionText, int textColor, int actionColor) {
        this.context = context;
        this.title = title;
        this.actionText = actionText;
        this.textColor = textColor;
        this.actionColor = actionColor;
    }

    public CafeBar build() {
        builder = CafeBar.builder(context)
                .theme(CafeBarTheme.Custom(Color.parseColor("#202125")))
                .duration(CafeBar.Duration.LONG)
                .content(title)
                .floating(true)
                .contentTypeface("OpenSans-Light.ttf");

        cafeBar = builder.build();
        View v = cafeBar.getView();
        // TODO: Increase the padding of the view
//        v.setBackground(context.getResources().getDrawable(R.drawable.bg_cafebar_background));
        // TODO: change the action color
        return cafeBar;
    }

    public void setAction(CafeBarCallback cafeBarCallback) {
        cafeBar.setAction(actionText, actionColor, cafeBarCallback);
    }
}
