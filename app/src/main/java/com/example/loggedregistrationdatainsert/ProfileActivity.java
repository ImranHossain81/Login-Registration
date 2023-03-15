package com.example.loggedregistrationdatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.loggedregistrationdatainsert.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.pName.setText(getIntent().getStringExtra("name"));
        binding.pPhone.setText(getIntent().getStringExtra("phone"));
    }
}

// this prroject is not full complited //project name Logged /////////////////////////////////