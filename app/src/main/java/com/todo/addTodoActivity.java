package com.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.todo.Animator.MutableBackgroundSpanAnimator;
import com.todo.components.Interval;
import com.todo.components.MutableBackgroundSpan;

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

//        newTodo.addTextChangedListener(new TextWatcher() {
//            private boolean justChanged = false;
//            private String previous;
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                previous = charSequence.toString();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (previous != String.valueOf(newTodo.getText())) {
//                    String text = String.valueOf(newTodo.getText());
//                    SpannableString ss = new SpannableString(text);
//                    ss.setSpan(new UnderlineSpan(), 0, text.length(), 0);
//                    ss.setSpan(new BackgroundColorSpan(Color.GRAY), 0, text.length(), 0);
//                    newTodo.setText(ss);
//                    justChanged = true;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    justChanged = false;
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
////                justChanged = true;
//            }
//        });

//        new Interval(new Interval.CallBack() {
//            @Override
//            public void onEvent() {
//                SpannableString ss = new SpannableString("234890daskjhafauasfhlafjhakdf");
//                MutableBackgroundSpan span = new MutableBackgroundSpan(123, Color.WHITE);
//                ss.setSpan(span, 2, 8, 0);
//                MutableBackgroundSpanAnimator<EditText> animator = new MutableBackgroundSpanAnimator<EditText>(span, ss, newTodo);
//            }
//        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SpannableString ss = new SpannableString("234890daskjhafauasfhlafjhakdf");
                MutableBackgroundSpan span = new MutableBackgroundSpan(123, Color.WHITE);
                ss.setSpan(span, 2, 8, 0);
                MutableBackgroundSpanAnimator<EditText> animator = new MutableBackgroundSpanAnimator<EditText>(span, ss, newTodo);
                animator.start();
                handler.postDelayed(this, 1000);
            }
        }, 1000);

    }
}