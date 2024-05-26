package com.example.serviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(v -> startService(new Intent(MainActivity.this, MyService.class)));

        stopButton.setOnClickListener(v -> stopService(new Intent(MainActivity.this, MyService.class)));
    }

}