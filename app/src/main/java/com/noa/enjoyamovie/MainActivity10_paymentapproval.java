package com.noa.enjoyamovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity10_paymentapproval extends AppCompatActivity {
TextView ticketsSelection;
    TextView paymentDetails;
    TextView approval;
    TextView sum;
    TextView title;
    TextView movienameorder;
    TextView movietimeorder;
    TextView hallandseatingorder;
    TextView totalpaymentorder;
    TextView cashorcardorder;
    Button tosum;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    AlertDialog.Builder builder;
    Intent intent2;
    String email;
    String phoneNumber;
    String time;
    String date;
    String MovieName;
    String wayofpaymentbuyed;
    String username;
    String password;
    String id;
    int chosed ;
    String places;
    int sumMoney;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    private SensorLightHandler mSensorLightHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10_paymentapproval);

        builder=new AlertDialog.Builder(this);
        title = (TextView) findViewById(R.id.title);
        ticketsSelection = (TextView) findViewById(R.id.ticketsSelection);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        paymentDetails = (TextView) findViewById(R.id.paymentDetails);
        approval = (TextView) findViewById(R.id.approval);
        sum = (TextView) findViewById(R.id.sum);
        movienameorder = (TextView) findViewById(R.id.movienameorder);
        movietimeorder = (TextView) findViewById(R.id.movietimeorder);
        cashorcardorder = (TextView) findViewById(R.id.cashorcardorder);
        hallandseatingorder = (TextView) findViewById(R.id.hallandseatingorder);
        totalpaymentorder = (TextView) findViewById(R.id.totalpaymentorder);

        tosum = (Button) findViewById(R.id.tosum);
       Click();
        tosum.setOnClickListener(this::Click1);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }
    public void Click() {
        intent2 = getIntent();
        email=intent2.getStringExtra("email");
        phoneNumber=intent2.getStringExtra("phonenumber");
        time= intent2.getStringExtra("time");
        date= intent2.getStringExtra("date");
        MovieName = intent2.getStringExtra("name");
        wayofpaymentbuyed=intent2.getStringExtra("pay");
        username= intent2.getStringExtra("username");
        password= intent2.getStringExtra("password");
        id = intent2.getStringExtra("iduser");
        chosed=Integer.parseInt(intent2.getStringExtra("amount"));
        places=intent2.getStringExtra("seats");
        sumMoney=Integer.parseInt(intent2.getStringExtra("sum"));
        movienameorder.setText("movie name: "+MovieName);
        movietimeorder.setText("time: "+time+", date: "+date);
        hallandseatingorder.setText(""+places);
        totalpaymentorder.setText("total sum: "+sumMoney);
        cashorcardorder.setText("way of payment: "+wayofpaymentbuyed);
        if (MovieName.equals("Avatar"))
            hallandseatingorder.setText("hall: " + 1 + ""+places);
        if (MovieName.equals("My sweet monster"))
            hallandseatingorder.setText("hall: " + 2 + ""+places);
        if (MovieName.equals("The menu"))
            hallandseatingorder.setText("hall: " + 3 + ""+places);
        if (MovieName.equals("Shotgun wedding"))
            hallandseatingorder.setText("hall: " + 4 + ""+places);
        if (MovieName.equals("Beautiful desaster"))
            hallandseatingorder.setText("hall: " + 5 + ", "+places);
        if (MovieName.equals("Puss in boots"))
            hallandseatingorder.setText("hall: " + 6 + ""+places);
        if (MovieName.equals("Puss in boots 2"))
            hallandseatingorder.setText("hall: " + 7 + ""+places);
        if (MovieName.equals("Alvin and the chipmanks"))
            hallandseatingorder.setText("hall: " + 8 + ""+places);
        if (MovieName.equals("Cinderella"))
            hallandseatingorder.setText("hall: " + 9 + ""+places);
        if (MovieName.equals("The little mermaid"))
            hallandseatingorder.setText("hall: " + 10 + ""+places);
    }
    public void Click1(View v) {
        //הפעולה שולחת את הנתונים בהודעה ואימייל ואת המשתמש למסך הסיכום

        Order orders = new Order(username, id ,password, wayofpaymentbuyed,date,time,sumMoney);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Orders");
        databaseReference.child(MovieName).setValue(orders).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                Toast.makeText(getApplicationContext(),"order saved",Toast.LENGTH_LONG).show();

                if(!email.equals("")) {
                    String re = email;
                    String[] r = re.split(",");
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, r);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "your movie appointment");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "user "+orders.getUsername()+" thank you for ordering."+" movie name:" + MovieName + ", time:" + orders.getMovieTime() + ", date:" + orders.getMovieDate() + ", " + places + ", total payment:" + orders.getSumMoney());

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Choose an email client"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "There is no email client installed", Toast.LENGTH_LONG).show();
                    }
                }
                ActivityCompat.requestPermissions(MainActivity10_paymentapproval.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, "user "+orders.getUsername()+" thank you for ordering."+" movie name:"+MovieName+", time:"+orders.getMovieTime()+", date:"+orders.getMovieDate()+", "+places+", total payment:"+orders.getSumMoney(), null, null);
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity11_sumorder.class);
                startActivity(intent);
            }
        });




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
        mSensorLightHandler.unregister();
    }
}