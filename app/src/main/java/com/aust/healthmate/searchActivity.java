package com.aust.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;;

public class searchActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    CardView card1,card2;
    String entCard,pediaCard;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);

        button=(Button)findViewById(R.id.GO);
        card1=(CardView)findViewById(R.id.card1);
        card2=(CardView)findViewById(R.id.card2);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);

        button.setOnClickListener(this);

        /*Map<String,Object> note=new HashMap<>();
        note.put("name","National Institute of Neuro Sciences & Hospital");
        note.put("address","Shahid Shahabuddin Shorok, Dhaka 1207");
        note.put("phone","02-9112709");
        db.collection("Hospitals").document("Four").set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(searchActivity.this,"note saved",Toast.LENGTH_LONG).show();

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(searchActivity.this,"Failure",Toast.LENGTH_LONG).show();


                    }
                });*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.card1)
        {
            entCard="ent";

        }
        if(v.getId()==R.id.card2)
        {
            entCard="pediatric";

        }
        if(v.getId()==R.id.GO) {
            Intent intent = new Intent(searchActivity.this, cardActivity.class);
            intent.putExtra("key",entCard);
            startActivity(intent);
        }


    }
}