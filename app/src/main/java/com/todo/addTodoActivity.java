package com.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.todo.Animator.MutableBackgroundSpanAnimator;
import com.todo.components.Interval;
import com.todo.components.MutableBackgroundSpan;

public class addTodoActivity extends AppCompatActivity {
    private EditText newTodo;
    private SurfaceView surfaceView;
    private Canvas canvas;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_todo);

        newTodo = (EditText) findViewById(R.id.add_todo);
        surfaceView = (SurfaceView) findViewById(R.id.add_todo_background_canvas);
        textView = (TextView) findViewById(R.id.add_todo_check_text_length);

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {}
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {}

            @Override
            public void surfaceCreated(SurfaceHolder surface) {
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                canvas = surface.lockCanvas();
                canvas.drawRect(0, 0, 0, 0, paint);
                newTodo.setText("Hello World, I am Karan Gandhi");
            }
        });

        newTodo.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int after) {
                String text = newTodo.getText().toString();
                String textBefore = text.substring(0, text.indexOf("Karan Gandhi"));

                textView.setText("Karan Gandhi");
                textView.measure(0, 0);
                int width = textView.getMeasuredWidth();
                int height = textView.getMeasuredHeight();

                textView.setText(textBefore);
                textView.measure(0, 0);
                int leftOffset = textView.getMeasuredWidth();

                Paint underline = new Paint();
                underline.setColor(Color.BLACK);
                canvas.drawRect(leftOffset, height + 3, canvas.getWidth() - (leftOffset + width), canvas.getHeight() - (height + 5), underline);
            }
        });

//        new Interval(new Interval.CallBack() {
//            @Override
//            public void onEvent() {
//                SpannableString ss = new SpannableString("234890daskjhafauasfhlafjhakdf");
//                MutableBackgroundSpan span = new MutableBackgroundSpan(123, Color.WHITE);
//                ss.setSpan(span, 2, 8, 0);
//                MutableBackgroundSpanAnimator<EditText> animator = new MutableBackgroundSpanAnimator<EditText>(span, ss, newTodo);
//            }
//        });




//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SpannableString ss = new SpannableString("234890daskjhafauasfhlafjhakdf");
//                MutableBackgroundSpan span = new MutableBackgroundSpan(123, Color.WHITE);
//                ss.setSpan(span, 2, 8, 0);
//                MutableBackgroundSpanAnimator<EditText> animator = new MutableBackgroundSpanAnimator<EditText>(span, ss, newTodo);
//                animator.start();
//                handler.postDelayed(this, 1000);
//            }
//        }, 1000);

    }
}