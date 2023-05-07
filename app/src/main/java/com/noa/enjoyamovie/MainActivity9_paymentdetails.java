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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.noa.enjoyamovie.Activity.MainActivity2_seatselection;

public class MainActivity9_paymentdetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView asteriskoneOne;
    TextView firstnamebuy;
    TextView asteriskoneTwo;
    TextView lastnamebuy;
    TextView emailbuy;
    TextView asteriskoneFour;
    TextView phonenumberbuy;
    TextView titlet;
    TextView asteriskoneFive;
    TextView wayofpaymentbuy;
    TextView asteriskoneSix;
    TextView cardnumberbuy;
    TextView asteriskoneSeven;
    TextView threedigitsbuy;
    EditText firstnamebuyed;
    EditText lastnamebuyed;
    EditText emailbuyed;
    EditText phonenumberbuyed;
    Spinner wayofpaymentbuyed;
    EditText cardnumberbuyed;
    EditText cardvaliditybuyed;
    EditText threedigitsbuyed;
    Button toapproval;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    AlertDialog.Builder builder;
    Intent intent2;
    String time;
    String date;
    String MovieName;
    String username;
    String password;
    String id ;
    int chosed ;
    String places;
    int sumMoney;
    private SensorLightHandler mSensorLightHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9_paymentdetails);

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
        emailbuy = (TextView) findViewById(R.id.emailbuy);
        asteriskoneFour = (TextView) findViewById(R.id.asteriskoneFour);
        phonenumberbuy = (TextView) findViewById(R.id.phonenumberbuy);
        titlet = (TextView) findViewById(R.id.titlet);
        asteriskoneFive = (TextView) findViewById(R.id.asteriskoneFive);
        wayofpaymentbuy = (TextView) findViewById(R.id.wayofpaymentbuy);
        asteriskoneSix = (TextView) findViewById(R.id.asteriskoneSix);
        cardnumberbuy = (TextView) findViewById(R.id.cardnumberbuy);
        asteriskoneSeven = (TextView) findViewById(R.id.asteriskoneSeven);
        threedigitsbuy = (TextView) findViewById(R.id.threedigitsbuy);
        firstnamebuyed = (EditText) findViewById(R.id.firstnamebuyed);
        lastnamebuyed = (EditText) findViewById(R.id.lastnamebuyed);
        emailbuyed = (EditText) findViewById(R.id.emailbuyed);
        threedigitsbuyed = (EditText) findViewById(R.id.threedigitsbuyed);
        phonenumberbuyed = (EditText) findViewById(R.id.phonenumberbuyed);
        cardnumberbuyed = (EditText) findViewById(R.id.cardnumberbuyed);
        wayofpaymentbuyed = (Spinner) findViewById(R.id.wayofpaymentbuyed);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Weight2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wayofpaymentbuyed.setOnItemSelectedListener(this);
        toapproval = (Button) findViewById(R.id.toapproval);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        toapproval.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //הפעולה מאזינה לספינר ובמידה והמשתמש בחר לשלם במזומן היא לא מראה לו את השדות להזנת אשראי
        String cardOrCash=adapterView.getItemAtPosition(i).toString();
        if(cardOrCash.equals("cash"))
        {
            cardnumberbuyed.setVisibility(View.GONE);
            threedigitsbuyed.setVisibility(View.GONE);
        }
        else{
            cardnumberbuyed.setVisibility(View.VISIBLE);
            threedigitsbuyed.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    public void Click2(View v) {
        //הפעולה מעבירה נתונים ואת המשתמש למסך מידע על ההזמנה ולפני זה בודקת תקינות קלט
        intent2 = getIntent();
        time= intent2.getStringExtra("time");
        date= intent2.getStringExtra("date");
        MovieName = intent2.getStringExtra("name");
        username= intent2.getStringExtra("username");
        password= intent2.getStringExtra("password");
        id = intent2.getStringExtra("iduser");
        chosed=Integer.parseInt(intent2.getStringExtra("amount"));
        places=intent2.getStringExtra("seats");
        sumMoney=Integer.parseInt(intent2.getStringExtra("sum"));
        if(firstnamebuyed.getText().toString().length()>=2 && firstnamebuyed.getText().toString().length()<=10)
        {
            if(lastnamebuyed.getText().toString().length()>=2 && firstnamebuyed.getText().toString().length()<=15)
            {
                if( phonenumberbuyed.getText().toString().length()==10) {
                    if (wayofpaymentbuyed.getSelectedItem().equals("card"))
                    {
                        if (cardnumberbuyed.getText().toString().length() >= 8 && cardnumberbuyed.getText().toString().length() <= 19)
                        {
                                if(threedigitsbuyed.getText().toString().length()==3)
                                {
                                    finish();
                                    Intent intent = new Intent(this, MainActivity10_paymentapproval.class);
                                    intent.putExtra("email", emailbuyed.getText().toString());
                                    intent.putExtra("phonenumber", phonenumberbuyed.getText().toString());
                                    intent.putExtra("time", time);
                                    intent.putExtra("date", date);
                                    intent.putExtra("name", MovieName);
                                    intent.putExtra("pay", wayofpaymentbuyed.getSelectedItem().toString());
                                    intent.putExtra("username", username);
                                    intent.putExtra("password", password);
                                    intent.putExtra("iduser", id);
                                    intent.putExtra("seats", places);
                                    intent.putExtra("amount", "" + chosed);
                                    intent.putExtra("sum", "" + sumMoney);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"please enter 3 digits",Toast.LENGTH_SHORT).show();
                                }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"card number should be between 8-19 digits",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        if (wayofpaymentbuyed.getSelectedItem().equals("cash")) {
                            cardnumberbuyed.setVisibility(View.GONE);
                            threedigitsbuyed.setVisibility(View.GONE);
                            finish();
                            Intent intent = new Intent(this, MainActivity10_paymentapproval.class);
                            intent.putExtra("email", emailbuyed.getText().toString());
                            intent.putExtra("phonenumber", phonenumberbuyed.getText().toString());
                            intent.putExtra("time", time);
                            intent.putExtra("date", date);
                            intent.putExtra("name", MovieName);
                            intent.putExtra("pay", wayofpaymentbuyed.getSelectedItem().toString());
                            intent.putExtra("username", username);
                            intent.putExtra("password", password);
                            intent.putExtra("iduser", id);
                            intent.putExtra("seats", places);
                            intent.putExtra("amount", "" + chosed);
                            intent.putExtra("sum", "" + sumMoney);
                            startActivity(intent);
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"phone number should be 10 digits",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"last name should be between 2-15 letters",Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"first name should be between 2-10 letters",Toast.LENGTH_SHORT).show();
        }

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