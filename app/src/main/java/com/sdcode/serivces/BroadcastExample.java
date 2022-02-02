package com.sdcode.serivces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BroadcastExample extends AppCompatActivity {
//    BroadcastReceiverClass broadcastReceiverClass = new BroadcastReceiverClass();
    BroadcastReceiverClass exampleBroadcastReceiver = new BroadcastReceiverClass();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcase_sender);

        textView = findViewById(R.id.text_view);

//        IntentFilter filter = new IntentFilter("com.codinginflow.EXAMPLE_ACTION");
//        registerReceiver(exampleBroadcastReceiver, filter);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("com.sdcode.serivces.EXAMPLE_ACTION");
        intent.putExtra("com.sdcode.serivces.EXTRA_TEXT", "Broadcast received");
        sendBroadcast(intent);
    }

    private final BroadcastReceiverClass broadcastReceiverClass = new BroadcastReceiverClass() {
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context,intent);
            String receivedText = intent.getStringExtra("com.sdcode.serivces.EXTRA_TEXT");
            textView.setText(receivedText);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter("com.sdcode.serivces.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiverClass, filter);

        IntentFilter filterConnection = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiverClass, filterConnection);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverClass);
    }
}