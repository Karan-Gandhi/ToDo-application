package com.todo.components;

import android.graphics.Color;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.util.Property;

public class MutableBackgroundSpan extends BackgroundColorSpan {
    private int alpha, backgroundColor;

    public MutableBackgroundSpan(int alpha, int color) {
        super(color);
        this.alpha = alpha;
        this.backgroundColor = color;
    }

    public MutableBackgroundSpan(Parcel src) {
        super(src);
        this.backgroundColor = src.readInt();
        this.alpha = src.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(backgroundColor);
        dest.writeFloat(alpha);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.bgColor = getBackgroundColor();
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public float getAlpha() {
        return alpha;
    }

    @Override
    public int getBackgroundColor() {
        return Color.argb(alpha, Color.red(backgroundColor), Color.green(backgroundColor), Color.blue(backgroundColor));
    }

    public static final Property<MutableBackgroundSpan, Integer> MUTABLE_BACKGROUND_SPAN_INTEGER_PROPERTY = new Property<MutableBackgroundSpan, Integer>(Integer.class, "MUTABLE_BACKGROUND_SPAN_INTEGER_PROPERTY") {
        @Override
        public void set(MutableBackgroundSpan span, Integer val) {
            span.setBackgroundColor(val);
        }

        @Override
        public Integer get(MutableBackgroundSpan mutableBackgroundSpan) {
            return mutableBackgroundSpan.getBackgroundColor();
        }
    };
}