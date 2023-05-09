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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity13_sign_up extends AppCompatActivity {
    TextView title;
    TextView ruleid;
    TextView rulepassword;
    TextView ruleusername;
    EditText username;
    EditText password;
    EditText id;
    Button letsgo;
    Button back;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    FirebaseDatabase firebaseDatabase;
    AlertDialog.Builder builder;
    DatabaseReference databaseReference;
    private SensorLightHandler mSensorLightHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13_sign_up);

        builder = new AlertDialog.Builder(this);
        title = (TextView) findViewById(R.id.title);
        ruleid = (TextView) findViewById(R.id.ruleid);
        rulepassword = (TextView) findViewById(R.id.rulepassword);
        ruleusername = (TextView) findViewById(R.id.ruleusername);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        id = (EditText) findViewById(R.id.id);
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
        //הפעולה מעבירה למסך כניסה השני של התחברות או הרשמה
        Intent intent = new Intent(this, MainActivity5_signing.class);
        startActivity(intent);
        finish();
    }

    public void Click2(View v) {
        //הפעולה בודקת את תקינות הקלט, שומרת את נתוני המשתמש לפיירבייס ושולפת את נתוני המשתמש מהפיירבייס כדי לבדוק אם משתמש זה כבר קיים במערכת
        databaseReference=FirebaseDatabase.getInstance().getReference("Users");
        if(checkUserName(username.getText().toString()))
        {
            databaseReference.child(username.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(Task<DataSnapshot> task) {
                    if (task.isSuccessful()) {
                        if (task.getResult().exists()) {
                            Toast.makeText(MainActivity13_sign_up.this, "user already exists", Toast.LENGTH_SHORT).show();
                        } else {

                            if (!username.getText().toString().equals("") && !password.getText().toString().equals("") && !id.getText().toString().equals("")) {
                                if (checkUserName(username.getText().toString()) && checkPassword(password.getText().toString()) && checkId(id.getText().toString())) {
                                    Users users = new Users(username.getText().toString(), (id.getText().toString()),(password.getText().toString()));
                                    databaseReference.child(username.getText().toString()).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(Task<Void> task) {
                                            Toast.makeText(getApplicationContext(),"hello "+username.getText().toString(),Toast.LENGTH_LONG).show();
                                            username.setText("");
                                            password.setText("");
                                            id.setText("");
                                            finish();
                                            Intent intent = new Intent(getApplicationContext(), MainActivity4_movies.class);
                                            intent.putExtra("username",username.getText().toString());
                                            intent.putExtra("password",password.getText().toString());
                                            intent.putExtra("iduser",id.getText().toString());
                                            startActivity(intent);
                                        }
                                    });

                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"make sure all the info is correct",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"please fill all the fields",Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        Toast.makeText(MainActivity13_sign_up.this, "failed to read", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(MainActivity13_sign_up.this, "make sure all the info is correct", Toast.LENGTH_SHORT).show();
        }

    }

    public Boolean checkUserName(String username) {
        //הפעולה בודקת את תקינות הקלט של השם משתמש
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
        //הפעולה בודקת את תקינות הקלט של הססמא
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
        return true;
    }
     public Boolean checkId(String id) {
        //הפעולה בודקת את תקינות הקלט של התעודת זהות
        if(id.length()==9 && id.length()>0)
          return true;
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
        Intent music=new Intent(getApplicationContext(),MyService.class);
        stopService(music);
        mSensorLightHandler.unregister();
    }
}