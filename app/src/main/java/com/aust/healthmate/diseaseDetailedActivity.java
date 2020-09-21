package com.aust.healthmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class diseaseDetailedActivity extends AppCompatActivity {
    TextView foodText,lifeStyleText;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_detailed);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        this.setTitle(title);
        foodText = (TextView)findViewById(R.id.foodTextViewId);
        lifeStyleText = (TextView)findViewById(R.id.lifeStyleTextViewId);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        String disease = bundle.getString("disease");
        DocumentReference documentReference = fStore.collection("healthCareInformation").document(disease);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                foodText.setText(documentSnapshot.getString("food"));
                lifeStyleText.setText(documentSnapshot.getString("lifeStyle"));
            }
        });
    }
}