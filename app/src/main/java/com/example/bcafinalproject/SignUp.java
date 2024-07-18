package com.example.bcafinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    private EditText fullname, email, password;
    private Button btnSignUp;
    private TextView tvAlreadyLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignup);
        tvAlreadyLogin = findViewById(R.id.tvalreadylogin);

        btnSignUp.setOnClickListener(v -> {
            // Add sign-up logic here
        });

        tvAlreadyLogin.setOnClickListener(v -> {
            // Navigate to Login activity
            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);
        });
    }
}

