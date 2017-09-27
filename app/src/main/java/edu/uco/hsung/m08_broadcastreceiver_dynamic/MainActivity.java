package edu.uco.hsung.m08_broadcastreceiver_dynamic;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private BroadcastReceiver receiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intentName = getResources().getString(R.string.custom_intent);
                sendBroadcast(new Intent(intentName));
            }
        });

        intentFilter = new IntentFilter(getResources().getString(R.string.custom_intent2));
        receiver = new MyBroadcastReceiverDynamic();
        registerReceiver(receiver, intentFilter);

        Button b2 = (Button) findViewById(R.id.send2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(getResources().getString(R.string.custom_intent2)));
            }
        });
    }

    @Override
    protected void onRestart() {
        registerReceiver(receiver, intentFilter);
        super.onRestart();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }
}
