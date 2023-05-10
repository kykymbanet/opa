package com.example.ona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    private TextView textTimer;
    private EditText codeEdit;
    private TextView resend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textTimer=findViewById(R.id.textView16);
        setTimer();
        EditText number1=findViewById(R.id.editTextNumber);
        EditText number2=findViewById(R.id.editTextNumber2);
        EditText number3=findViewById(R.id.editTextNumber3);
        EditText number4=findViewById(R.id.editTextNumber4);
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton2);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        number1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = number1.getText().toString();
                if (s.length()==1){
                    number2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        number2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = number2.getText().toString();
                if (s.length()==0){
                    number1.requestFocus();
                }
                if (s.length()==1){
                    number3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        number3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = number3.getText().toString();
                if (s.length()==0){
                    number2.requestFocus();
                }
                if (s.length()==1){
                    number4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        number4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = number4.getText().toString();
                if (s.length()==0){
                    number3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setTimer() {
        CountDownTimer count = new CountDownTimer(59000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textTimer.setText("Отправить код повторно можно \n будет через "+millisUntilFinished/1000+ " секунд");
            }

            @Override
            public void onFinish() {
                textTimer.setText("Отправить код повторно");
                textTimer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setTimer();
                    }
                });
            }
        };
        count.start();
    }
}