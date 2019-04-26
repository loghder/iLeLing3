package com.iLeLing.hebut;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    private Register.TimeCount time;
    private Button btnGetcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        time = new Register.TimeCount(60000, 1000);
        btnGetcode=(Button) findViewById(R.id.btn_getcode);
        btnGetcode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                time.start();
            }
        });
    }
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btnGetcode.setBackgroundColor(Color.parseColor("#B6B6D8"));
            btnGetcode.setClickable(false);
            btnGetcode.setText("("+millisUntilFinished / 1000 +") 秒后可重新发送");
        }

        @Override
        public void onFinish() {
            btnGetcode.setText("重新获取验证码");
            btnGetcode.setClickable(true);
            btnGetcode.setBackgroundColor(Color.parseColor("#4EB84A"));

        }
    }
}


