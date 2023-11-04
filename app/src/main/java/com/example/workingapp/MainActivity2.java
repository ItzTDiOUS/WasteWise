package com.example.workingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    Button loginbutton, signupbutton;

    TextInputLayout username_var, password_var, confirm_password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sign_up);

        loginbutton = findViewById(R.id.login);
        signupbutton = findViewById(R.id.signupbtn);
        username_var = findViewById(R.id.username_box);
        password_var = findViewById(R.id.password_box);
        confirm_password_var = findViewById(R.id.confirm_password_box);

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_var.getEditText().getText().toString();
                String password = password_var.getEditText().getText().toString();
                String confirm_password = confirm_password_var.getEditText().getText().toString();

                if (password.equals(confirm_password)) {
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    reference = firebaseDatabase.getReference("Admin");

                    String username_s = username_var.getEditText().getText().toString();
                    String password_s = password_var.getEditText().getText().toString();

                    UserData userData = new UserData(username_s, password_s);

                    // Use push() to generate a unique key for each user
                    reference.child(username_s).setValue(userData);

                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    confirm_password_var.setError("Passwords do not match");
                }
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
