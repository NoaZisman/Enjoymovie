package com.noa.enjoyamovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity13_sign_up extends AppCompatActivity {
    TextView title;
    EditText username;
    EditText password;
    EditText id;
    EditText gmail;
    Button letsgo;
    Button back;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13_sign_up);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
        myReceiver = new IncomingCall_Reciver();
        filter = new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver, filter);
        builder = new AlertDialog.Builder(this);
        title = (TextView) findViewById(R.id.title);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        id = (EditText) findViewById(R.id.id);
        gmail = (EditText) findViewById(R.id.gmail);
        letsgo = (Button) findViewById(R.id.letsgo);
        back = (Button) findViewById(R.id.back);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        back.setOnClickListener(this::Click1);
        letsgo.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }

    public void Click1(View v) {
        Intent intent = new Intent(this, MainActivity5_signing.class);
        startActivity(intent);
        finish();
    }

    public void Click2(View v) {
       // if (!username.equals("") && !password.getText().toString().equals("")) {
        //    if (checkUserName(username.getText().toString()) && checkPassword(password.getText().toString())) {
                Intent intent = new Intent(this, MainActivity4_movies.class);
                startActivity(intent);
                finish();
          //  }
       // }
    }

    /*public Boolean checkUserName(String username) {
        if (!username.equals("")) {
            if (username.length() < 3 || username.length() > 10) return false;
            int i = 0;
            while (i < username.length()) {
                if (username.charAt(i) >= 'a' && username.charAt(i) <= 'z')
                    i++;
                else if (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')
                    i++;
                else break;
            }
            if (i == username.length()) return true;
        }
        return false;
    }

    public Boolean checkPassword(String password) {
        if (!password.equals("")) {
            if (password.length() < 3 || password.length() > 12)
                return false;
            int i = 0;
            int bigCnt = 0;
            int smallCnt = 0;
            int numCnt = 0;
            while (i < password.length()) {
                if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                    smallCnt++;
                    i++;
                } else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    bigCnt++;
                    i++;
                } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    numCnt++;
                    i++;
                } else return false;
            }
            if (bigCnt > 0 && smallCnt > 0 && numCnt > 0) return true;
        }
        return false;
    }
    // public Boolean checkId(String id) {
    //    if(id.length()<9 && id.length()>0)


    //  return false;
    // }
*/
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