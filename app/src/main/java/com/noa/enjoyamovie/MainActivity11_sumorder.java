package com.noa.enjoyamovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity11_sumorder extends AppCompatActivity {
 TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView titletwo;
    Button exitapp;
    Button tohomescreen;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11_sumorder);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        builder=new AlertDialog.Builder(this);
        title = (TextView) findViewById(R.id.title);
        ticketsSelection = (TextView) findViewById(R.id.ticketsSelection);
        paymentDetails = (TextView) findViewById(R.id.paymentDetails);
        approval = (TextView) findViewById(R.id.approval);
        sum = (TextView) findViewById(R.id.sum);
        titletwo = (TextView) findViewById(R.id.titletwo);
        exitapp = (Button) findViewById(R.id.exitapp);
        tohomescreen = (Button) findViewById(R.id.tohomescreen);
        exitapp.setOnClickListener(this::Click1);
        tohomescreen.setOnClickListener(this::Click2);
    }

    public void Click1(View v) {
        Toast.makeText(getApplicationContext(),"closing app",Toast.LENGTH_LONG).show();
        finishAndRemoveTask();
        finishAffinity();
    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity4_movies.class);
        startActivity(intent);

    }
}