package com.aust.healthmate;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
public class detailsActivity extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<User> userList;
    private CustomAdapter customAdapter;
    public detailsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        userList = new ArrayList<>();

        customAdapter = new CustomAdapter(detailsActivity.this,userList);

        listView = findViewById(R.id.listViewId);
    }
    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {


                userList.clear();
                for(DataSnapshot dataSnapshot1 : datasnapshot.getChildren())
                {
                    User user = dataSnapshot1.getValue(User.class);
                    userList.add(user);
                }

                listView.setAdapter(customAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}