package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorInformationActivity extends AppCompatActivity {
    EditText drugEditText,companyNameEditText,dosageEditText,medicalConditionEditText,expiryDateEditText,sideEffectsEditText;
    Button saveButton;
    String drug,companyName,dosage,medicalCondition,expiryName,sideEffects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_information);
        this.setTitle("Doctor Information");
        drugEditText = (EditText)findViewById(R.id.drugId);
        companyNameEditText= (EditText)findViewById(R.id.companyNameId);
        dosageEditText= (EditText)findViewById(R.id.dosageId);
        medicalConditionEditText= (EditText)findViewById(R.id.medicalConditionId);
        expiryDateEditText= (EditText)findViewById(R.id.expiryDateId);
        sideEffectsEditText= (EditText)findViewById(R.id.sideEffectsId);
        saveButton = (Button)findViewById(R.id.saveButtonId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData() {

        drug = drugEditText.getText().toString().trim();
        companyName = companyNameEditText.getText().toString().trim();
        medicalCondition = medicalConditionEditText.getText().toString().trim();
        expiryName = expiryDateEditText.getText().toString().trim();
        dosage = dosageEditText.getText().toString().trim();
        sideEffects = sideEffectsEditText.getText().toString().trim();


           /*if(drug==null)
            {
                drugEditText.setError("Drug name required");
                drugEditText.requestFocus();
                return;
            }
            if(companyName==null)
            {
                companyNameEditText.setError("Company Name required");
                companyNameEditText.requestFocus();
                return;
            }
            if(medicalCondition==null)
            {
               medicalConditionEditText.setError("Medical Condition required");
                medicalConditionEditText.requestFocus();
                return;
            }
            if(expiryName==null)
            {
                expiryDateEditText.setError("Expiry Date required");
                expiryDateEditText.requestFocus();
                return;
            }
            if(dosage==null)
            {
                dosageEditText.setError("Dosage required");
                dosageEditText.requestFocus();
                return;
            }
            if(sideEffects==null)
            {
                sideEffectsEditText.setError("Side Effects required");
                sideEffectsEditText.requestFocus();
                return;
            }*/

    }




}