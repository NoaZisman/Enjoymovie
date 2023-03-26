package com.noa.enjoyamovie;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5_signing extends AppCompatActivity {
Button signin;
Button signup;
AlertDialog.Builder builder;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_signing);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        builder=new AlertDialog.Builder(this);
        signin.setOnClickListener(this::Click1);
        signup.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
                builder.setTitle("Alert").setMessage("Do you want to close the app").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        Toast.makeText(getApplicationContext(),"closing app",Toast.LENGTH_LONG).show();
                        Intent music=new Intent(getApplicationContext(),MyService.class);
                        stopService(music);
                        finishAndRemoveTask();
                        finishAffinity();
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

                return true;
            case R.id.item2:
                finish();
                Intent intent = new Intent(this, MainActivity7_aboutcreator.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                finish();
                intent = new Intent(this, MainActivity6_aboutproject.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity12_sign_in.class);
        startActivity(intent);
    }

    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity13_sign_up.class);
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