package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Relative_Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;
    String dose,timpepicker,medicine;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_);
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            dose=bundle.getString("doseName");
            timpepicker=bundle.getString("timePicker");
            medicine=bundle.getString("medicineName");

        }
        ArrayList<ExampleItem> exampleList=new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.tablet2,R.drawable.ticksign,timpepicker,"Napa",dose));
        mRecyclerView =findViewById(R.id.recylerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager= new LinearLayoutManager(this);
        mAdapter= new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}