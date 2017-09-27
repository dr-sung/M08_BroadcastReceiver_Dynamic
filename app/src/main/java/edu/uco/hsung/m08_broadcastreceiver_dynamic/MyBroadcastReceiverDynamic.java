package edu.uco.hsung.m08_broadcastreceiver_dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiverDynamic extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intent Received by Dynamic Receiver",
                Toast.LENGTH_SHORT).show();
    }
}
