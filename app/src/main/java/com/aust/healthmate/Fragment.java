package com.aust.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Fragment extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    TextView textview;
    EditText editText2;
    Button editText;
    TimePickerDialog timePickerDialog;
    Button button,customButton;
    ImageView rightsign;
    String dose,medicinename=" ",timepicker=" ",timetext;

    String hour,Mminute;

    String[] doseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        spinner = (Spinner) findViewById(R.id.spinner);
        textview = (TextView) findViewById(R.id.dose);
        //button = (Button) findViewById(R.id.click);
        //rightsign=(ImageView) findViewById(R.id.rightsign);
        customButton=(Button)findViewById(R.id.custom_button);



        editText =  findViewById(R.id.timePicker);
        editText2=findViewById(R.id.medicineName);
        medicinename=editText2.getText().toString();
        timepicker=editText.getText().toString();
        doseName = getResources().getStringArray(R.array.Dose_name);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sample2_layout, R.id.textView, doseName);
        spinner.setAdapter(adapter);
        editText.setOnClickListener(this);
        customButton.setOnClickListener(this);
        //button.setOnClickListener(this);
        //rightsign.setOnClickListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dose= doseName[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.timePicker) {
            TimePicker timePicker = new TimePicker(this);

            int currentHour = timePicker.getCurrentHour();
            int currentMinute = timePicker.getCurrentMinute();
            timePickerDialog = new TimePickerDialog(this,

                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            editText.setText(hourOfDay + ":" + minute);
                            hour=Integer.toString(hourOfDay);
                            Mminute=Integer.toString(minute);
                            timetext=hour+":"+Mminute;
                            Calendar c= Calendar.getInstance();
                            c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                            c.set(Calendar.MINUTE,minute);
                            c.set(Calendar.SECOND,0);
                            updateTimeText(c);
                            startAlarm(c);


                        }
                    }, currentHour, currentMinute, android.text.format.DateFormat.is24HourFormat(this));
            timePickerDialog.show();

        }
        /*if(v.getId()==R.id.click)
        {
            Intent intent=new Intent(this,NotificationActivity.class);
            startActivity(intent);
        }*/
        /*if(v.getId()==R.id.rightsign)
        {
            Intent rightSign = new Intent(this,Relative_Activity.class);
            rightSign.putExtra("medicineName",medicinename);
            rightSign.putExtra("timePicker",timetext);
            rightSign.putExtra("doseName",dose);
            startActivity(rightSign);
        }*/

        if(v.getId()==R.id.custom_button)
        {

            Intent nextActivity=new Intent(this,Relative_Activity.class);
            nextActivity.putExtra("medicineName",medicinename);
            nextActivity.putExtra("timePicker",timetext);
            nextActivity.putExtra("doseName",dose);
            Toast.makeText(this,"Alarm set successfully",Toast.LENGTH_LONG).show();
            startActivity(nextActivity);
        }
    }
    public void updateTimeText(Calendar c)
    {


    }
    private void startAlarm(Calendar c)
    {
        AlarmManager alarmManager= (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent= new Intent(this,AlertReceiver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(this,1,intent,0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
    }

}