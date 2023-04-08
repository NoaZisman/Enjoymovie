package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.noa.enjoyamovie.Firebase;
import com.noa.enjoyamovie.IncomingCall_Reciver;
import com.noa.enjoyamovie.MainActivity8_ticketselection;
import com.noa.enjoyamovie.MyService;
import com.noa.enjoyamovie.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2_seatselection extends AppCompatActivity {

    LinearLayout title1;
    AlertDialog.Builder builder;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button bt10;
    Button bt11;
    Button bt12;
    Button bt13;
    Button bt14;
    Button bt15;
    Button bt16;
    Button bt17;
    Button bt18;
    Button bt19;
    Button bt20;
    Button bt21;
    Button bt22;
    Button bt23;
    Button bt24;
    Button bt25;
    Button bt26;
    Button bt27;
    Button bt28;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    TextView title;
    TextView greentext;
    TextView greytext;
    TextView orangetext;
    Button back;
    Button topay;
    ImageView screen;
    ImageView green;
    ImageView grey;
    ImageView orange;
    Intent intentg;
    String MovieName;
    int i;
    boolean[][] flag = new  boolean[4][7];
    public int[][] seats = new int[4][7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_seatselection);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        intentg=getIntent();
        i= intentg.getIntExtra("id",0);
        //לקבל גם את השעה מבין 3 שעות אפשריות, מספר האולם
        title1 = (LinearLayout) findViewById(R.id.title1);
        title = (TextView) findViewById(R.id.title);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt10 = (Button) findViewById(R.id.bt10);
        bt11 = (Button) findViewById(R.id.bt11);
        bt12 = (Button) findViewById(R.id.bt12);
        bt13 = (Button) findViewById(R.id.bt13);
        bt14 = (Button) findViewById(R.id.bt14);
        bt15 = (Button) findViewById(R.id.bt15);
        bt16 = (Button) findViewById(R.id.bt16);
        bt17 = (Button) findViewById(R.id.bt17);
        bt18 = (Button) findViewById(R.id.bt18);
        bt19 = (Button) findViewById(R.id.bt19);
        bt20 = (Button) findViewById(R.id.bt20);
        bt21 = (Button) findViewById(R.id.bt21);
        bt22 = (Button) findViewById(R.id.bt22);
        bt23 = (Button) findViewById(R.id.bt23);
        bt24 = (Button) findViewById(R.id.bt24);
        bt25 = (Button) findViewById(R.id.bt25);
        bt26 = (Button) findViewById(R.id.bt26);
        bt27 = (Button) findViewById(R.id.bt27);
        bt28 = (Button) findViewById(R.id.bt28);
        back = (Button) findViewById(R.id.back);
        topay = (Button) findViewById(R.id.topay);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        greentext = (TextView) findViewById(R.id.greentext);
        greytext = (TextView) findViewById(R.id.greytext);
        orangetext = (TextView) findViewById(R.id.orangetext);
        green = (ImageView) findViewById(R.id.green);
        grey = (ImageView) findViewById(R.id.grey);
        orange = (ImageView) findViewById(R.id.orange);
        screen = (ImageView) findViewById(R.id.screen);
        builder=new AlertDialog.Builder(this);
        back.setOnClickListener(this::Click1);
        topay.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);

        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j]=false;
            }

        }

        Intent intent = getIntent();
        time= intent.getStringExtra("time");
        date= intent.getStringExtra("date");
        String name = intent.getStringExtra("name");

        MovieName = name;
        Read2dArray(name);

    }

    String time,date;
    public static List<List<Integer>> convertIntArrayToArrayList(int[][] intArray) {
        List<List<Integer>> arrayList = new ArrayList<>();
        for (int[] row : intArray) {
            List<Integer> rowList = new ArrayList<>();
            for (int num : row) {
                rowList.add(num);
            }
            arrayList.add(rowList);
        }
        return arrayList;
    }
    public void Save2dArray(int[][] seats,String name) {
        Firebase firebase = new Firebase();
        firebase.saveIntList(convertIntArrayToArrayList(seats),MovieName,date+"/"+time);
    }


    public static int[][] convertArrayListToIntArray(List<List<Integer>> arrayList) {
        int numRows = arrayList.size();
        if(numRows == 0){
            return new int[4][7];
        }
        int numCols = arrayList.get(0).size();

        int[][] intArray = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                intArray[i][j] = arrayList.get(i).get(j);
            }
        }
        return intArray;
    }

    public void Read2dArray(String name)  {
        Firebase firebase = new Firebase();
        firebase.readIntList(new Firebase.OnDataLoadedListener() {
            @Override
            public void onDataLoaded(List<List<Integer>> arrayList) {
                seats = convertArrayListToIntArray(arrayList);
                Resources res = getResources();
                int i,j;
                for (i=0;i<4;i++){
                    for(j=0;j<7;j++){
                        int id = res.getIdentifier("bt"+(i*7+j+1), "id", getApplicationContext().getPackageName());
                        if (seats[i][j] == 1){
                            ((Button)findViewById(id)).setBackgroundTintList(ColorStateList.valueOf(Color.argb(255, 128, 124, 124)));
                        }
                        else{
                            int finalJ = j;
                            int finalI = i;
                            ((Button)findViewById(id)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if (!flag[finalI][finalJ]) {
                                        flag[finalI][finalJ]=true;
                                        seats[finalI][finalJ] = 1;
                                        ((Button)findViewById(id)).setBackgroundTintList(ColorStateList.valueOf(Color.argb(255, 255, 152, 0)));
                                    }else{
                                        flag[finalI][finalJ]=false;
                                        seats[finalI][finalJ] = 1;
                                        ((Button)findViewById(id)).setBackgroundTintList(ColorStateList.valueOf(Color.argb(255, 109, 200, 113)));
                                    }

                                }
                            });
                        }
                    }
                }
            }
        },MovieName, date + "/" + time);


    }





    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity3_moviedetails.class);
        startActivity(intent);
    }
    public void Click2(View v) {
        Intent intent = new Intent(this, MainActivity8_ticketselection.class);
        Save2dArray(seats,MovieName);
        intent.putExtra("id", i);
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