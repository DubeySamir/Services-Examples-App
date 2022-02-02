package com.sdcode.serivces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btn_broadcastExample,btn_NotificationExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_broadcastExample = findViewById(R.id.btn_broadcastExample);
        btn_NotificationExample = findViewById(R.id.btn_NotificationExample);

        btn_broadcastExample.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BroadcastExample.class));
        });

        btn_NotificationExample.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),NotificationExample.class));
        });
    }
}