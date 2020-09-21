package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        this.setTitle("BMI Calculator");

        final EditText edWeg,edHei;
        final TextView txtRes,txtInter;
        Button btnRes,btnReset;

        edWeg=(EditText) findViewById(R.id.edweg);
        edHei=(EditText) findViewById(R.id.edhei);

        txtInter=(TextView) findViewById(R.id.txtinter);
        txtRes=(TextView) findViewById(R.id.txtres);

        btnRes= (Button) findViewById(R.id.btnres);
        btnReset= (Button) findViewById(R.id.btnreset);

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg= edWeg.getText().toString();
                String strhei= edHei.getText().toString();

                if(strweg.equals((""))){
                    edWeg.setError("Please Enter Your Weight");
                    edWeg.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                    edHei.setError("Please Enter Your Weight");
                    edHei.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiVlaue = BMCalculation(weight,height);
                //String str= String.valueOf(bmiVlaue);

                txtInter.setText(interpreteBMI(bmiVlaue));
                txtRes.setText("BMI= "+bmiVlaue);



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");
                txtInter.setText("");
                txtRes.setText("");
            }
        });

    }

    public float BMCalculation(float weight,float height){
        return weight / (height * height);
    }
    public String interpreteBMI(float bmiValue){
        if(bmiValue<16){
            return "Sevely UnderWeight";
        }
        else if(bmiValue <18.5){
            return "UnderWeight";
        }
        else if(bmiValue <25){
            return "Normal";
        }
        else if(bmiValue <30){
            return "OverWeight";
        }
        else
            return "Obese";
    }
}