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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailEditText,passwordEditText;
    Button signInButton;
    TextView signUpTextView;
    private FirebaseAuth mAuth;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");
        mAuth = FirebaseAuth.getInstance();
        emailEditText = (EditText)findViewById(R.id.emailEditTextId);
        passwordEditText = (EditText)findViewById(R.id.passwordEditTextId);
        signInButton = (Button)findViewById(R.id.signInButtonId);
        signUpTextView = (TextView)findViewById(R.id.signUpTextViewId);
        progress = (ProgressBar)findViewById(R.id.progressId);
        signInButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.signInButtonId:
                userLogIn();
                break;
            case R.id.signUpTextViewId:
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogIn() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            emailEditText.setError("Enter an email");
            emailEditText.requestFocus();
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

        progress.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Intent intent = new Intent (getApplicationContext(),HealthMateActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    emailEditText.setText("");
                    passwordEditText.setText("");
                    startActivity(intent);

                }else{
                    task.getException().printStackTrace();
                    Toast.makeText(getApplicationContext(), "Sign In unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}