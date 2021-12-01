package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.uas.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.pict, R.drawable.male, R.drawable.female,R.drawable.male,
                R.drawable.male, R.drawable.male, R.drawable.male,R.drawable.female,R.drawable.female,
                R.drawable.male, R.drawable.female, R.drawable.female, R.drawable.female};
        String[] name = {"Muhammad Fauzan Alkhairi","Febrian","Siti","Tony",
                "Budi","Joni","Santoso","Ani","Ayana",
                "Anto","Ryujin","Bella","Kirby"};
        String[] nim = {"16748845", "20352345", "20345146", "20451684",
                "20354865", "20156478", "20130246", "20123598", "20154622",
                "20455538", "20024502", "20456566", "20151502"};
        String[] noPhone = {"081234567890", "012345678912", "021234567890", "031234567891",
                "041234567892", "051234567893", "061234567894", "071234567895", "081234567896",
                "091234567897", "001234567898", "002123456789", "091234567809"};
        String[] city = {
                "Bukittinggi","Bukittinggi","Jakarta","Loss Angeless",
                "Bandung","Las Vegas","Surabaya","Yogyakarta","Seoul",
                "Palembang","Seoul","Moskow","London"
        };

        ArrayList<User> userArrayList= new ArrayList<>();

        for (int i = 0; i< imageId.length;i++) {
            User user = new User(name[i],nim[i],noPhone[i],city[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(Home.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), UserActivity.class);
                i.putExtra("name", name[position]);
                i.putExtra("nim", nim[position]);
                i.putExtra("noPhone", noPhone[position]);
                i.putExtra("city",city[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);
            }
        });

        // get no action-bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}