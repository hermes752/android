package com.example.cursomovil.camara.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TelephonyReceiver extends BroadcastReceiver {
    private final String RECEIVER="RECEIVER";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(RECEIVER, "ConectionReceiver on Receive()");
        Log.d(RECEIVER, "ACTION: "+intent.getAction());

    }
}
