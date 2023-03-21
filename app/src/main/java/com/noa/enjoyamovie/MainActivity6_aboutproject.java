package com.noa.enjoyamovie;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity6_aboutproject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6_aboutproject);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
    }
}