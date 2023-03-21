package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
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

import com.noa.enjoyamovie.IncomingCall_Reciver;
import com.noa.enjoyamovie.MainActivity8_ticketselection;
import com.noa.enjoyamovie.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity2_seatselection extends AppCompatActivity {

    LinearLayout title1;
    AlertDialog.Builder builder;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ten;
    Button eleven;
    Button twelve;
    Button thirteen;
    Button fourteen;
    Button fifteen;
    Button sixteen;
    Button seventeen;
    Button eighteen;
    Button nineteen;
    Button twenty;
    Button twentyOne;
    Button twentyTwo;
    Button twentyThree;
    Button twentyFour;
    Button twentyFive;
    Button twentySix;
    Button twentySeven;
    Button twentyEight;
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
    public int[][] seats = new int[7][4];
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
        title1 = (LinearLayout) findViewById(R.id.title1);
        title = (TextView) findViewById(R.id.title);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        ten = (Button) findViewById(R.id.ten);
        eleven = (Button) findViewById(R.id.eleven);
        twelve = (Button) findViewById(R.id.twelve);
        thirteen = (Button) findViewById(R.id.thirteen);
        fourteen = (Button) findViewById(R.id.fourteen);
        fifteen = (Button) findViewById(R.id.fifteen);
        sixteen = (Button) findViewById(R.id.sixteen);
        seventeen = (Button) findViewById(R.id.seventeen);
        eighteen = (Button) findViewById(R.id.eighteen);
        nineteen = (Button) findViewById(R.id.nineteen);
        twenty = (Button) findViewById(R.id.twenty);
        twentyOne = (Button) findViewById(R.id.twentyOne);
        twentyTwo = (Button) findViewById(R.id.twentyTwo);
        twentyThree = (Button) findViewById(R.id.twentyThree);
        twentyFour = (Button) findViewById(R.id.twentyFour);
        twentyFive = (Button) findViewById(R.id.twentyFive);
        twentySix = (Button) findViewById(R.id.twentySix);
        twentySeven = (Button) findViewById(R.id.twentySeven);
        twentyEight = (Button) findViewById(R.id.twentyEight);
        back = (Button) findViewById(R.id.back);
        topay = (Button) findViewById(R.id.topay);
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

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        seats = Read2dArray(name);

        Resources res = getResources();
        int i,j;
        for (i=0;i<4;i++){
            for(j=0;j<7;j++){
                int id = res.getIdentifier("bt"+(i*7+j+1), "id", getApplicationContext().getPackageName());
                if (seats[j][i] == 1){
                    ((Button)findViewById(id)).setBackgroundTintList(ColorStateList.valueOf(Color.argb(255, 128, 124, 124)));
                }
                else{
                    int finalJ = j;
                    int finalI = i;
                    ((Button)findViewById(id)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            seats[finalJ][finalI] = 1;
                            ((Button)findViewById(id)).setBackgroundTintList(ColorStateList.valueOf(Color.argb(255, 255, 152, 0)));
                        }
                    });
                }

            }
        }



    }



    public void Save2dArray(int[][] seats,String name) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < seats.length; i++)//for each row
        {
            for(int j = 0; j < seats.length; j++)//for each column
            {
                builder.append(seats[i][j]+"");//append to the output string
                if(j < seats.length - 1)//if this is not the last row element
                    builder.append(",");//then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter( name + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(builder.toString());//save the string representation of the board
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int[][] Read2dArray(String name)  {
        String savedGameFile = name+".txt";
        int[][] seats = new int[9][9];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(savedGameFile));
        } catch (FileNotFoundException e) {
            Save2dArray(new int[7][4],name);
            return new int[7][4];
        }
        String line = "";
        int row = 0;
        while(true)
        {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] cols = line.split(","); //note that if you have used space as separator you have to split on " "
            int col = 0;
            for(String  c : cols)
            {
                seats[row][col] = Integer.parseInt(c);
                col++;
            }
            row++;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seats;
    }



    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity3_moviedetails.class);
        startActivity(intent);

    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity8_ticketselection.class);
        startActivity(intent);

    }
}