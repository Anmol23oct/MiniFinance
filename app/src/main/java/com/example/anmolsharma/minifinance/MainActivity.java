package com.example.anmolsharma.minifinance;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbar;
    int  i;
    float l;
    float f = (float) (0.0);
    TextView welcometext;
   // RelativeLayout registerlayout;
    CountDownTimer mCountDownTimer;
    Button ButtonA;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registerlayout = (RelativeLayout) findViewById(R.id.registerlayout);
        pbar = (ProgressBar) findViewById(R.id.progressBar);
        welcometext = (TextView) findViewById(R.id.welcometextview);
        ButtonA= (Button) findViewById(R.id.buttonA);
        final Intent intent=new Intent(MainActivity.this,Registerpage.class);
        myDb=new DatabaseHelper(this);

        i = 0;
        pbar.setVisibility(View.VISIBLE);
        welcometext.setVisibility(View.VISIBLE);

        pbar.setProgress(i);
        mCountDownTimer = new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                pbar.setProgress(i);
                f = (float) (f + 0.2);
               // Log.i("pbarvalued =", String.valueOf(f));
                welcometext.setAlpha(f);
                ButtonA.setAlpha(f);
            }

            @Override
            public void onFinish() {
                i++;
                pbar.setProgress(i);
                f = (float) (f + 0.2);
             //   Log.i("pbarvalued =", String.valueOf(f));
                welcometext.setAlpha(f);
                ButtonA.setAlpha(f);
            }

        };
        mCountDownTimer.start();
    }

    public void buttonclick(View v)
    {
        ButtonA= (Button) findViewById(R.id.buttonA);
        final Intent intent=new Intent(this,Registerpage.class);
        startActivity(intent);
    }

}
