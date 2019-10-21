package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressBar_id);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                appWork();

            }
        });

        thread.start();
    }

    private void doWork(){
        for (progress = 2; progress <= 100; progress = progress+2 ){
            try {
                Thread.sleep(70);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void appWork(){
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
