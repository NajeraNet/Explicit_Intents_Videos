package com.example.explicit_intents_videos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    //
    TextView tvWelcome;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //
        tvWelcome = findViewById(R.id.tvWelcome);
        //
    }
}