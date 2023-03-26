package com.noa.enjoyamovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.noa.enjoyamovie.Activity.MainActivity2_seatselection;
import com.noa.enjoyamovie.Activity.MainActivity3_moviedetails;

public class MainActivity8_ticketselection extends AppCompatActivity {
    AlertDialog.Builder builder;
    TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView infoOne;
    TextView infoTwo;
    TextView infoThree;
    TextView infoFour;
    TextView pricetextview;
    TextView amounttextview;
    TextView price;
    TextView amount;
    Button todetails;
    Button back;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    Intent intentg;
    int i;
    //לקבל גם את השעה מבין 3 שעות אפשריות, מספר האולם, מספר הכיסאות, מספר שורת ישיבה
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8_ticketselection);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        builder=new AlertDialog.Builder(this);
        intentg=getIntent();
        i= intentg.getIntExtra("id",0);
        title = (TextView) findViewById(R.id.title);
        ticketsSelection = (TextView) findViewById(R.id.ticketsSelection);
        paymentDetails = (TextView) findViewById(R.id.paymentDetails);
        approval = (TextView) findViewById(R.id.approval);
        sum = (TextView) findViewById(R.id.sum);
        infoOne = (TextView) findViewById(R.id.infoOne);
        infoTwo = (TextView) findViewById(R.id.infoTwo);
        infoThree = (TextView) findViewById(R.id.infoThree);
        infoFour = (TextView) findViewById(R.id.infoFour);
        pricetextview = (TextView) findViewById(R.id.pricetextview);
        amounttextview = (TextView) findViewById(R.id.amounttextview);
        price = (TextView) findViewById(R.id.price);
        amount = (TextView) findViewById(R.id.amount);
        todetails = (Button) findViewById(R.id.todetails);
        back = (Button) findViewById(R.id.back);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        back.setOnClickListener(this::Click1);
        todetails.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }

    public void Click1(View v) {
        finish();

    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity9_paymentdetails.class);
        startActivity(intent);

    }

    public void Click3(View v) {
        builder.setTitle("Alert").setMessage("Do you want to play music").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                Intent music=new Intent(getApplicationContext(),MyService.class);
                startService(music);
            }
        })
                .setNegativeButton("no", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void Click4(View v) {
        Intent music=new Intent(getApplicationContext(),MyService.class);
        stopService(music);
    }
}