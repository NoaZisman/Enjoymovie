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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity12_sign_in extends AppCompatActivity {
TextView title;
EditText username;
EditText password;
Button letsgo;
Button back;
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12_sign_in);
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
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        letsgo = (Button) findViewById(R.id.letsgo);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this::Click1);
        letsgo.setOnClickListener(this::Click2);
    }
    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity5_signing.class);
        startActivity(intent);

    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity4_movies.class);
        startActivity(intent);

    }
}