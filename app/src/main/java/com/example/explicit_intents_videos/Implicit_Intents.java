package com.example.explicit_intents_videos;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.explicit_intents_videos.databinding.ActivityImplicitIntentsBinding;

public class Implicit_Intents extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityImplicitIntentsBinding binding;
    //
    Button btnCall, btnCallFriend, btnOpenWeb, btnOpenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityImplicitIntentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_implicit_intents);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //
        btnCall = findViewById(R.id.btnCall);
        btnCallFriend = findViewById(R.id.btnCallFriend);
        btnOpenWeb = findViewById(R.id.btnOpenWeb);
        btnOpenMap = findViewById(R.id.btnopenMap);
        //
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewCall) {
                // TODO Call function
            }
        });
        //
        btnCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewCallFriend) {
                //TODO Call Friend function
            }
        });
        //
        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewOpenWeb) {
                //TODO Open Web function
            }
        });
        //
        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewOpenMap) {
                //TODO Open Map function
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_implicit_intents);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}