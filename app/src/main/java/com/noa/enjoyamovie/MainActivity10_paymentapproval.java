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

public class MainActivity10_paymentapproval extends AppCompatActivity {
TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView movienameorder;
    TextView movietimeorder;
    TextView hallandseatingorder;
    TextView totalpaymentorder;
    Button tosum;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10_paymentapproval);
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
        movienameorder = (TextView) findViewById(R.id.movienameorder);
        movietimeorder = (TextView) findViewById(R.id.movietimeorder);
        hallandseatingorder = (TextView) findViewById(R.id.hallandseatingorder);
        totalpaymentorder = (TextView) findViewById(R.id.totalpaymentorder);
        tosum = (Button) findViewById(R.id.tosum);
        tosum.setOnClickListener(this::Click1);
    }

    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity11_sumorder.class);
        startActivity(intent);

    }
}