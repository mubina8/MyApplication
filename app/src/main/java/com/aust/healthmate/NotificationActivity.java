package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NotificationActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;
    NotificationHelper mNotificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        editText1=(EditText) findViewById(R.id.channel1);
        editText2=(EditText)findViewById(R.id.channel2);
        button1=  (Button)findViewById(R.id.button1);
        button2=  (Button)findViewById(R.id.button2);
        mNotificationHelper=new NotificationHelper(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(editText1.getText().toString(),editText2.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(editText1.getText().toString(),editText2.getText().toString());

            }
        });
    }
    public void sendOnChannel1(String title,String message)
    {
        NotificationCompat.Builder nb=mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManager().notify(1,nb.build());

    }
    public void sendOnChannel2(String title,String message)
    {
        NotificationCompat.Builder nb=mNotificationHelper.getChannel2Notification(title,message);
        mNotificationHelper.getManager().notify(2,nb.build());
    }
}