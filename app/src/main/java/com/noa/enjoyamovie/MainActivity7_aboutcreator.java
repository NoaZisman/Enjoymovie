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
import android.widget.TextView;

public class MainActivity7_aboutcreator extends AppCompatActivity {
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    TextView title;
    TextView myid;
    TextView myname;
    TextView teachername;
    TextView date;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7_aboutcreator);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        title = (TextView) findViewById(R.id.title);
        myid = (TextView) findViewById(R.id.myid);
        myname = (TextView) findViewById(R.id.myname);
        teachername = (TextView) findViewById(R.id.teachername);
        date = (TextView) findViewById(R.id.date);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        builder = new AlertDialog.Builder(this);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
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