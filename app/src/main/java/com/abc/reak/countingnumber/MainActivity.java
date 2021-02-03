package com.abc.reak.countingnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter_tv);
        startCounterAnimation(487.4, counter);
    }

    private void startCounterAnimation(int target, TextView textView) {

        int interval = Math.round(target/40);
        final int[] currentVale = {0};

        new CountDownTimer(4000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentVale[0] += interval;
                textView.setText(String.valueOf(currentVale[0]));
            }

            @Override
            public void onFinish() {
                textView.setText(String.valueOf(target));
            }
        }.start();

    }

    private void startCounterAnimation(double target, TextView textView) {

        double interval = target/40;
        final double[] currentValue = {0};

        new CountDownTimer(4000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentValue[0] += interval;
                textView.setText(String.valueOf(roundToTwoDecimals(currentValue[0])));
            }

            @Override
            public void onFinish() {
                textView.setText(String.valueOf(roundToTwoDecimals(target)));
            }
        }.start();

    }

    public double roundToTwoDecimals(double target){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(target));
    }

}