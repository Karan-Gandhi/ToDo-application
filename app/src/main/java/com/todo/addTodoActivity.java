package com.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addTodoActivity extends AppCompatActivity {
    private EditText newTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_todo);

        newTodo = (EditText) findViewById(R.id.add_todo);

//        final Handler checkForEntities = new Handler();
//        checkForEntities.postDelayed(new Runnable() {
//            private long time = 0;
//            String previous = "";
//            int cursorStart = 1;
//
//            @Override
//            public void run() {
//                String text = String.valueOf(newTodo.getText());
//                if (text.length() != 0 && !previous.equals(text)) {
//                    SpannableString ss = new SpannableString(text);
//                    ss.setSpan(new UnderlineSpan(), 0, text.length(), 0);
//                    ss.setSpan(new BackgroundColorSpan(Color.GRAY), 0, text.length(), 0);
//                    newTodo.setText(ss);
//                    newTodo.setSelection(cursorStart);
//                    cursorStart = newTodo.getSelectionStart();
//                }
//                checkForEntities.postDelayed(this, 1200);
//            }
//        }, 1200);

        newTodo.addTextChangedListener(new TextWatcher() {
            private boolean justChanged = false;
            private String previous;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previous = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (previous != String.valueOf(newTodo.getText())) {
                    String text = String.valueOf(newTodo.getText());
                    SpannableString ss = new SpannableString(text);
                    ss.setSpan(new UnderlineSpan(), 0, text.length(), 0);
                    ss.setSpan(new BackgroundColorSpan(Color.GRAY), 0, text.length(), 0);
                    newTodo.setText(ss);
                    justChanged = true;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    justChanged = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                justChanged = true;
            }
        });

        SpannableString ss = new SpannableString("sdafghgfhgfhhf");
        ss.setSpan(new UnderlineSpan(), 2, 8, 0);
    }
}