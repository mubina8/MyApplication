package com.aust.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText,passwordEditText,phoneNumberEditText,userNameEditText,addressEditText;
    Button signUpButton;
    TextView signInTextView;
    private FirebaseAuth mAuth;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");

        emailEditText = (EditText)findViewById(R.id.emailEditTextId);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextId);
        phoneNumberEditText = (EditText)findViewById(R.id.phoneNumberId);
        userNameEditText = (EditText)findViewById(R.id.userNameId);
        addressEditText = (EditText)findViewById(R.id.addressEditTextId);
        signUpButton = (Button)findViewById(R.id.signUpButtonId);
        signInTextView = (TextView)findViewById(R.id.signInTextViewId);
        progress = (ProgressBar)findViewById(R.id.progressId);
        mAuth = FirebaseAuth.getInstance();
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String user = userNameEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
               if(user.isEmpty())
                {
                userNameEditText.setError("Enter an User Name");
                userNameEditText.requestFocus();
                return;
                }
                if(phoneNumber.isEmpty())
                {
                    phoneNumberEditText.setError("Enter a phone number");
                    phoneNumberEditText.requestFocus();
                    return;
                }
                if(phoneNumber.length()<12)
                {
                    phoneNumberEditText.setError("Enter a valid phone number");
                    phoneNumberEditText.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    emailEditText.setError("Enter an valid email address");
                    emailEditText.requestFocus();
                    return;
                }

                if(password.isEmpty())
                {
                    passwordEditText.setError("Enter a password");
                    passwordEditText.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    passwordEditText.setError("Enter minimum 5 character");
                    passwordEditText.requestFocus();
                    return;
                }
               if(address.isEmpty())
                {
                  addressEditText.setError("Enter a valid Address");
                  addressEditText.requestFocus();
                  return;
                }
               else{

                   registerUser(email,password);


                }


            }
        });
    }

    private void registerUser(String email, String password) {
        progress.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(), "Registration is completed", Toast.LENGTH_SHORT).show();
                        userNameEditText.setText("");
                        emailEditText.setText("");
                        passwordEditText.setText("");
                        phoneNumberEditText.setText("");
                        addressEditText.setText("");
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "User is already exist", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Registration is not completed", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

}