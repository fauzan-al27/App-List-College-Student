package com.example.uas;

import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uas.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {
            String name = intent.getStringExtra("name");
            String nim = intent.getStringExtra("nim");
            String phone = intent.getStringExtra("noPhone");
            String city = intent.getStringExtra("city");
            int imageid = intent.getIntExtra("imageId",R.drawable.pict);

            binding.nameProfile.setText(name);
            binding.nim.setText(nim);
            binding.phoneProfile.setText(phone);
            binding.cityProfile.setText(city);
            binding.profileImage.setImageResource(imageid);
        }

        binding.imageButton.setOnClickListener((view -> {
            Intent i = new Intent(UserActivity.this, Home.class);
            i.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(i);
        }));

        // get no action-bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}