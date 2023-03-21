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

import com.noa.enjoyamovie.Activity.MainActivity2_seatselection;

public class MainActivity9_paymentdetails extends AppCompatActivity {
TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView asteriskoneOne;
    TextView firstnamebuy;
    TextView asteriskoneTwo;
    TextView lastnamebuy;
    TextView asteriskoneTree;
    TextView emailbuy;
    TextView asteriskoneFour;
    TextView phonenumberbuy;
    TextView titlet;
    TextView asteriskoneFive;
    TextView wayofpaymentbuy;
    TextView asteriskoneSix;
    TextView cardnumberbuy;
    TextView asteriskoneSeven;
    TextView cardvaliditybuy;
    TextView asteriskoneEight;
    TextView threedigitsbuy;
    EditText firstnamebuyed;
    EditText lastnamebuyed;
    EditText emailbuyed;
    EditText phonenumberbuyed;
    EditText wayofpaymentbuyed;
    EditText cardnumberbuyed;
    EditText cardvaliditybuyed;
    EditText threedigitsbuyed;
    Button back;
    Button toapproval;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9_paymentdetails);
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
        asteriskoneOne = (TextView) findViewById(R.id.asteriskoneOne);
        firstnamebuy = (TextView) findViewById(R.id.firstnamebuy);
        asteriskoneTwo = (TextView) findViewById(R.id.asteriskoneTwo);
        lastnamebuy = (TextView) findViewById(R.id.lastnamebuy);
        asteriskoneTree = (TextView) findViewById(R.id.asteriskoneTree);
        emailbuy = (TextView) findViewById(R.id.emailbuy);
        asteriskoneFour = (TextView) findViewById(R.id.asteriskoneFour);
        phonenumberbuy = (TextView) findViewById(R.id.phonenumberbuy);
        titlet = (TextView) findViewById(R.id.titlet);
        asteriskoneFive = (TextView) findViewById(R.id.asteriskoneFive);
        wayofpaymentbuy = (TextView) findViewById(R.id.wayofpaymentbuy);
        asteriskoneSix = (TextView) findViewById(R.id.asteriskoneSix);
        cardnumberbuy = (TextView) findViewById(R.id.cardnumberbuy);
        asteriskoneSeven = (TextView) findViewById(R.id.asteriskoneSeven);
        cardvaliditybuy = (TextView) findViewById(R.id.cardvaliditybuy);
        asteriskoneEight = (TextView) findViewById(R.id.asteriskoneEight);
        threedigitsbuy = (TextView) findViewById(R.id.threedigitsbuy);
        firstnamebuyed = (EditText) findViewById(R.id.firstnamebuyed);
        lastnamebuyed = (EditText) findViewById(R.id.lastnamebuyed);
        emailbuyed = (EditText) findViewById(R.id.emailbuyed);
        threedigitsbuyed = (EditText) findViewById(R.id.threedigitsbuyed);
        cardvaliditybuyed = (EditText) findViewById(R.id.cardvaliditybuyed);
        phonenumberbuyed = (EditText) findViewById(R.id.phonenumberbuyed);
        cardnumberbuyed = (EditText) findViewById(R.id.cardnumberbuyed);
        wayofpaymentbuyed = (EditText) findViewById(R.id.wayofpaymentbuyed);
        toapproval = (Button) findViewById(R.id.toapproval);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this::Click1);
        toapproval.setOnClickListener(this::Click2);
    }
    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity8_ticketselection.class);
        startActivity(intent);

    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity9_paymentdetails.class);
        startActivity(intent);

    }
}