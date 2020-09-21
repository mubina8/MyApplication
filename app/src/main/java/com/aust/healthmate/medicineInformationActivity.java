package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class medicineInformationActivity extends AppCompatActivity {
    Button saveDataButton, loadDataButton;
    EditText hospitalEditText, locationEditText;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_information);
        setContentView(R.layout.activity_medicine_information);
        this.setTitle("Medicines");


        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        saveDataButton = findViewById(R.id.saveDataButtonId);
        loadDataButton = findViewById(R.id.loadDataButtonId);

        hospitalEditText = findViewById(R.id.hospitalEditTextId);
        locationEditText = findViewById(R.id.locationEditTextId);

        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), detailsActivity.class);
                startActivity(intent);
            }
        });
        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData()
    {
        String hospital = hospitalEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();

        User user = new User(hospital, location);

        databaseReference.child(key).setValue(user);
        Toast.makeText(getApplicationContext(), "Hospital info is added", Toast.LENGTH_LONG).show();

        hospitalEditText.setText("");
        locationEditText.setText("");
    }

}