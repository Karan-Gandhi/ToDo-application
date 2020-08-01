package com.todo.components;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.danimahardhika.cafebar.CafeBar;
import com.danimahardhika.cafebar.CafeBarCallback;
import com.danimahardhika.cafebar.CafeBarTheme;
import com.todo.R;

public class FloatingCafebar {
    private static final int MIN_CAFEBAR_WIDTH = 1000;

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
                .showShadow(false)
                .floating(true)
                .contentTypeface("OpenSans-Light.ttf");

        cafeBar = builder.build();
        LinearLayout layout = (LinearLayout) cafeBar.getView();
        layout.setBackground(context.getDrawable(R.drawable.bg_cafebar_background));
        layout.setMinimumWidth(MIN_CAFEBAR_WIDTH);
        TextView content = (TextView) layout.findViewById(com.danimahardhika.cafebar.R.id.cafebar_content);
        content.setTextSize(13);
        return cafeBar;
    }

    public void setAction(CafeBarCallback cafeBarCallback) {
        cafeBar.setAction(actionText, actionColor, cafeBarCallback);
    }
}
