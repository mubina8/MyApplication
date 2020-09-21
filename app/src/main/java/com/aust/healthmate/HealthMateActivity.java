package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthMateActivity extends AppCompatActivity implements View.OnClickListener {
    Button healthCareButton,dietTipsButton,medicineReminderButton,informationButton,bmiCalculatorButton,locationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_mate);
        this.setTitle("Health Mate");
        healthCareButton = (Button)findViewById(R.id.healthCareId);
        dietTipsButton = (Button)findViewById(R.id.dietChartId);
        medicineReminderButton = (Button)findViewById(R.id.medicineReminderId);
        informationButton =   (Button)findViewById(R.id.InformationId);
        bmiCalculatorButton=(Button)findViewById(R.id.bmiCalculatorId);
        locationButton = (Button)findViewById(R.id.locationId);
        healthCareButton.setOnClickListener(this);
        dietTipsButton.setOnClickListener(this);
        medicineReminderButton.setOnClickListener(this);
        informationButton.setOnClickListener(this);
        bmiCalculatorButton.setOnClickListener(this);
        locationButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.healthCareId)
        {
            Intent intent = new Intent(getApplicationContext(), HealthCareActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.dietChartId)
        {
            Intent intent = new Intent(getApplicationContext(), dietTipsActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.InformationId)
        {
            Intent intent = new Intent(getApplicationContext(), medicineInformationActivity.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.bmiCalculatorId)
        {
            Intent intent = new Intent(getApplicationContext(), bmiCalculator.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.medicineReminderId)
        {
            Intent intent = new Intent(getApplicationContext(), reminderActivity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.locationId)
        {
            Intent intent = new Intent(getApplicationContext(),searchActivity.class);
            startActivity(intent);
        }

    }
}