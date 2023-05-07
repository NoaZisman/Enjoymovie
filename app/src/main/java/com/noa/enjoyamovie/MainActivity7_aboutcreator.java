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

import com.noa.enjoyamovie.Activity.MainActivity3_moviedetails;

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
    Button back;
    private SensorLightHandler mSensorLightHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7_aboutcreator);

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
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this::Click1);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }

    public void Click1(View v)
    {
        //הפעולה מעבירה את המשתמש למסך הראשי עם הסרטים
        finish();
        Intent intent = new Intent(this, MainActivity4_movies.class);
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