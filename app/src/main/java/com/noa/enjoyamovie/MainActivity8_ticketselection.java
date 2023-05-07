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
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    Intent intentg;
    int i;
    Intent intent2;
    String time;
    String date;
    String MovieName;
    String username;
    String password;
    String id;
    int chosed;
    int sumMoney;
    private SensorLightHandler mSensorLightHandler;
    //לקבל גם את השעה מבין 3 שעות אפשריות, מספר האולם, מספר הכיסאות, מספר שורת ישיבה
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8_ticketselection);

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
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        todetails.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
        chosed=Integer.parseInt(intentg.getStringExtra("amount" ));
        for(int i =0;i<chosed;i++){
            places+=intentg.getStringExtra("seat"+i);

        }
        amount.setText(""+chosed);
        sumMoney=chosed*47;
    }





    //shura : (int)num/4 seat : num%4;
    String places="";





    public void Click2(View v) {
        //הפעולה מעבירה נתונים ואת המשתמש למסך התשלום
        intent2 = getIntent();
        time= intent2.getStringExtra("time");
        date= intent2.getStringExtra("date");
        MovieName = intent2.getStringExtra("name");
        username= intent2.getStringExtra("username");
        password= intent2.getStringExtra("password");
        id = intent2.getStringExtra("iduser");
        finish();
        Intent intent = new Intent(this, MainActivity9_paymentdetails.class);
        intent.putExtra("time",time);
        intent.putExtra("date",date);
        intent.putExtra("name",MovieName);
        intent.putExtra("username",username);
        intent.putExtra("password",password);
        intent.putExtra("iduser",id);
        intent.putExtra("seats",places);
        intent.putExtra("amount",""+chosed);
        intent.putExtra("sum",""+sumMoney);
        startActivity(intent);

    }

    public void Click3(View v) {
        //שואל את המשתמש אם הוא רוצה לנגן מוזיקת רקע, במידה וכן הפעולה הולכת למחלקת הסרוויס ומתחילה לנגן
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
        // במידה והמשתמש רוצה לעצור את המוזיקה הפעולה הולכת למחלקת הסרוויס ועוצרת את המוזיקה
        Intent music=new Intent(getApplicationContext(),MyService.class);
        stopService(music);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorLightHandler = new SensorLightHandler(this);
        mSensorLightHandler.register();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Intent music=new Intent(getApplicationContext(),MyService.class);
        stopService(music);
        mSensorLightHandler.unregister();
    }
}