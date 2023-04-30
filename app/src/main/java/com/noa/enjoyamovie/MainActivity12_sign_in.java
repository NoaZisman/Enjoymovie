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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity12_sign_in extends AppCompatActivity {
TextView title;
EditText username;
TextView ruleid;
Button letsgo;
Button back;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
AlertDialog.Builder builder;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
    private SensorLightHandler mSensorLightHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12_sign_in);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        builder=new AlertDialog.Builder(this);
        title = (TextView) findViewById(R.id.title);
        username = (EditText) findViewById(R.id.username);
        ruleid = (TextView) findViewById(R.id.ruleid);
        letsgo = (Button) findViewById(R.id.letsgo);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this::Click1);
        letsgo.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
    }
    public void Click1(View v) {
        //הפעולה מעבירה למסך כניסה השני של התחברות או הרשמה
        finish();
        Intent intent = new Intent(this, MainActivity5_signing.class);
        startActivity(intent);

    }
    public void Click2(View v) {
        // הפעולה בודקת תקינות קלט ושולפת נתונים מהפיירבייס כדי לבדוק אם המשתמש כבר קיים במערכת
        if (!username.getText().toString().equals("")) {
            if (checkUserName(username.getText().toString())) {
                readData(username.getText().toString());
                username.setText("");
            }
            else{
                Toast.makeText(getApplicationContext(),"fill the data correctly",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(MainActivity12_sign_in.this, "fill the data", Toast.LENGTH_SHORT).show();
        }
    }

    private void readData(String username) {
        //הפעולה בודקת אם המשתמש קיים במערכת ולצורך זה שולפת נתונים מהפיירבייס, במידה וכן הפעולה מעבירה את המשתמש והנתונים למסך הראשי עם הסרטים
databaseReference=FirebaseDatabase.getInstance().getReference("Users");
databaseReference.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
    @Override
    public void onComplete(Task<DataSnapshot> task) {
        if(task.isSuccessful())
        {
            if (task.getResult().exists())
            {
                Toast.makeText(MainActivity12_sign_in.this, "welcome back", Toast.LENGTH_SHORT).show();
                DataSnapshot dataSnapshot=task.getResult();
                String username1= String.valueOf(dataSnapshot.child("username").getValue());
                String password1= String.valueOf(dataSnapshot.child("password").getValue());
                String id1= String.valueOf(dataSnapshot.child("id").getValue());
                Intent intent = new Intent(getApplicationContext(), MainActivity4_movies.class);
                intent.putExtra("username",username1);
                intent.putExtra("password",password1);
                intent.putExtra("iduser",id1);
                finish();
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity12_sign_in.this, "user doesn't exist", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(MainActivity12_sign_in.this, "failed to read", Toast.LENGTH_SHORT).show();
        }
    }
});
    }

    public Boolean checkUserName(String username) {
        //הפעולה בודקת את הקלט של השם משתמש
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