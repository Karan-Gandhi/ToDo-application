package com.todo.components;

import android.os.Handler;

import java.util.Objects;

public class Interval {
    private Interval.CallBack callBack;
    private Handler handler;

    public Interval(Interval.CallBack callBack) {
        this.callBack = callBack;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onEvent();
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public CallBack getCallBack() {
        return callBack;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Objects.equals(callBack, interval.callBack) &&
                Objects.equals(handler, interval.handler);
    }

    public int hashCode() {
        return Objects.hash(callBack, handler);
    }

    public static abstract class CallBack {
        public abstract void onEvent();
    }
}