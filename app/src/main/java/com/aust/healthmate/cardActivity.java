package com.aust.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class cardActivity extends AppCompatActivity {
    TextView mname,mlocation,mtype;
    TextView oname,olocation,otype;
    /* referencing the database*/
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteref= db.collection("Hospitals").document("First");
    private  DocumentReference noteref2=db.collection("Hospitals").document("Four");
    private  DocumentReference noteref3=db.collection("Hospitals").document("Second");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_card);
        /*findout the ids*/
        mname=(TextView)findViewById(R.id.name);
        mlocation=(TextView)findViewById(R.id.location);
        mtype=(TextView)findViewById(R.id.type);
        oname=(TextView)findViewById(R.id.name2);
        olocation=(TextView)findViewById(R.id.location2);
        otype=(TextView)findViewById(R.id.type2);


        Bundle bundle=getIntent().getExtras();
        String ent=bundle.getString("key");
        if(ent==null)
        {
            Toast.makeText(this,"ent is empty",Toast.LENGTH_LONG).show();
        }
        mname.setText(ent);


        /* Data for Card1*/
        if(ent.equals(ent)) {
            noteref.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {

                            if (documentSnapshot.exists()) {
                                String name = documentSnapshot.getString("name");
                                String location = documentSnapshot.getString("address");
                                String type = documentSnapshot.getString("type");
                                mname.setText(name);
                                mlocation.setText(location);
                                mtype.setText(type);


                            } else {
                                Toast.makeText(cardActivity.this, "Documnent didnt found", Toast.LENGTH_LONG).show();
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(cardActivity.this, "Failure", Toast.LENGTH_LONG).show();

                        }
                    });


            noteref2
                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        String name=documentSnapshot.getString("name");
                        String location=documentSnapshot.getString("address");

                        oname.setText(name);
                        olocation.setText(location);

                    }
                    else
                    {
                        Toast.makeText(cardActivity.this,"Document doesnt exist",Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
        /*Data for Card2*/

        if(ent.equals("pediatric"))
        {
            noteref3
                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())
                    {
                        String name=documentSnapshot.getString("name");
                        String location=documentSnapshot.getString("address");
                        String type=documentSnapshot.getString("type");
                        mname.setText(name);
                        mlocation.setText(location);
                        mtype.setText(type);
                    }

                }
            });

            noteref2
                    .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists())

                    {
                        String name=documentSnapshot.getString("name");
                        String location=documentSnapshot.getString("address");
                        mname.setText(name);
                        mlocation.setText(location);
                    }

                }
            });

        }

    }
}