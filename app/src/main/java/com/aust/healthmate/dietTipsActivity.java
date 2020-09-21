package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dietTipsActivity extends AppCompatActivity implements View.OnClickListener {
    Button dietButton,videoTipsButton,yogaButton,generalTipsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_tips);
        this.setTitle("Diet Tips");
        dietButton = (Button)findViewById(R.id.dietButtonId);
        videoTipsButton = (Button)findViewById(R.id.videoTipsButtonId);
        yogaButton = (Button)findViewById(R.id.yogaButtonId);
        generalTipsButton = (Button)findViewById(R.id.generalTipsButtonId);
        dietButton.setOnClickListener(this);
        videoTipsButton.setOnClickListener(this);
        yogaButton.setOnClickListener(this);
        generalTipsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.dietButtonId)
        {
            Intent intent = new Intent(getApplicationContext(), diet1Activity.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.videoTipsButtonId)
        {
            Intent intent = new Intent(getApplicationContext(), videoTipsActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.yogaButtonId)
        {
            Intent intent = new Intent(getApplicationContext(), yogaActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.generalTipsButtonId)
        {
            Intent intent = new Intent(getApplicationContext(), generalTipsActivity.class);
            startActivity(intent);
        }

    }
}