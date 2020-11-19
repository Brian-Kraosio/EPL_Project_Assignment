package com.example.eplclub.splashscreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eplclub.MainActivity;
import com.example.eplclub.eplClub.EplClubHome;

public class SpashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // langsung pindah ke MainActivity atau activity lain
        // begitu memasuki splash screen ini
        Intent intent = new Intent(this, EplClubHome.class);
        startActivity(intent);
        finish();
    }

}
