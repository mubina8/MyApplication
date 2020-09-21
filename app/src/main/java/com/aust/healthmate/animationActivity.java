package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class animationActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animation);

        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startAt();
            }

        });
        thread.start();


    }

    public void doWork()  {
        for(progress=10;progress<=100; progress=progress+10) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startAt()
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}