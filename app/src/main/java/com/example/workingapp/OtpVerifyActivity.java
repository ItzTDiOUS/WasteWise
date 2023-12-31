package com.example.workingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workingapp.databinding.ActivityOtpVerifyBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpVerifyActivity extends AppCompatActivity {

    private ActivityOtpVerifyBinding binding;
    private String verficationId;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpVerifyBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

        EditTextInput();
        binding.tvMobile.setText(String.format(
                "91-%s",getIntent().getStringExtra("phone")
        ));

        verficationId=getIntent().getStringExtra("verifcationId");
        binding.tvResendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtpVerifyActivity.this,"OTP Sent Successfully",Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBarVerify.setVisibility(View.VISIBLE);
                binding.btnVerify.setVisibility(View.INVISIBLE);
                if (binding.etC1.getText().toString().trim().isEmpty()||
                binding.etC2.getText().toString().trim().isEmpty()||
                binding.etC3.getText().toString().trim().isEmpty()||
                binding.etC4.getText().toString().trim().isEmpty()||
                binding.etC5.getText().toString().trim().isEmpty()||
                binding.etC6.getText().toString().trim().isEmpty()){
                    Toast.makeText(OtpVerifyActivity.this,"Please Enter OTP",Toast.LENGTH_SHORT).show();

                }
                else {
                        if (verficationId!=null){
                            String code= binding.etC1.getText().toString().trim()+
                                    binding.etC2.getText().toString().trim()+
                                    binding.etC3.getText().toString().trim()+
                                    binding.etC4.getText().toString().trim()+
                                    binding.etC5.getText().toString().trim()+
                                    binding.etC6.getText().toString().trim();
                            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verficationId, code);
                            FirebaseAuth.getInstance()
                                    .signInWithCredential(credential)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        binding.progressBarVerify.setVisibility(View.VISIBLE);
                                        binding.btnVerify.setVisibility(View.INVISIBLE);
                                        Intent intent=new Intent(OtpVerifyActivity.this, MainActivity2.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                    }
                                    else {
                                        binding.progressBarVerify.setVisibility(View.GONE);
                                        binding.btnVerify.setVisibility(View.VISIBLE);
                                        Toast.makeText(OtpVerifyActivity.this,"Invalid OTP",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                }

            }
        });
    }

    private void EditTextInput() {
        binding.etC1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etC5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.etC6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
