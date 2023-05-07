package com.noa.enjoyamovie;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.noa.enjoyamovie.Activity.MainActivity3_moviedetails;
import com.noa.enjoyamovie.Activity.MyAdapter;

import com.noa.enjoyamovie.Movie.MovieXML;

import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4_movies extends AppCompatActivity {


    ListView listView;
    LinearLayout title1;
    LinearLayoutManager linearLayoutManager;
    List<MovieXML> movieList;
    MyAdapter myAdapter;
    AlertDialog.Builder builder;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    Intent intent2;
    String username;
    String password;
    String id;
    private SensorLightHandler mSensorLightHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_movies);

        builder = new AlertDialog.Builder(this);
        title1 = (LinearLayout) findViewById(R.id.title1);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
        intent2 = getIntent();
        username= intent2.getStringExtra("username");
        password= intent2.getStringExtra("password");
        id = intent2.getStringExtra("iduser");
        initData();
        initListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //הפעולה מאזינה ומעבירה את המשתמש למסך עם המידע על סרט ספציפי
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieXML v = movieList.get(i);

                Intent intent = new Intent(getApplicationContext(), MainActivity3_moviedetails.class);
                intent.putExtra("id", i);
                intent.putExtra("name",movieList.get(i).getName());
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("iduser",id);
                startActivityForResult(intent, 1);
                finish();
            }
        });



    }
    private void initData() {
        //הפעולה מעבירה את הנתונים של הסרטים (נתונים שונים) לרשימה
        movieList = new ArrayList<>();
        movieList.add(new MovieXML("Avatar", R.drawable.movie_image_avatar, "imdb - 7.9", "2D", "192 min"));
        movieList.add(new MovieXML("My sweet monster", R.drawable.movie_image_mysweetmonster, "imdb - 4.9", "2D", "98 min"));
        movieList.add(new MovieXML("The menu", R.drawable.movie_image_themenu, "imdb - 7.3", "2D", "106 min"));
        movieList.add(new MovieXML("Shotgun wedding", R.drawable.movie_image_shotgunwedding, "imdb - 6.2", "2D", "102 min"));
        movieList.add(new MovieXML("Beautiful desaster", R.drawable.movie_image_beautifuldesaster, "imdb - 6.1", "2D", "130 min"));
        movieList.add(new MovieXML("Puss in boots", R.drawable.movie_image_pussinboots, "imdb - 6.6", "2D", "97 min"));
        movieList.add(new MovieXML("Puss in boots 2", R.drawable.movie_image_pussinbootstwo, "imdb - 7.9", "2D", "100 min"));
        movieList.add(new MovieXML("Alvin and the chipmanks", R.drawable.movie_image_chipmanks, "imdb - 4.3", "2D", "87 min"));
        movieList.add(new MovieXML("Cinderella", R.drawable.movie_image_cinderella, "imdb - 7.3", "2D", "74 min"));
        movieList.add(new MovieXML("The little mermaid", R.drawable.movie_image_little_mermaid, "imdb - 7.6", "2D", "83 min"));
    }

    private void initListView() {
        //הפעולה קוראת לאדפטר עם הרשימה של הסרטים
        listView = findViewById(R.id.listView);
        myAdapter = new MyAdapter(getApplicationContext(), movieList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        //תפריט של יציאה מהאפליקציה/ מידע על האפליקציה/ אודות המתכנת
        switch(item.getItemId())
        {
            case R.id.item1:
                builder.setTitle("Alert").setMessage("Do you want to close the app").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        Toast.makeText(getApplicationContext(),"closing app",Toast.LENGTH_LONG).show();
                        Intent music=new Intent(getApplicationContext(),MyService.class);
                        stopService(music);
                        finishAndRemoveTask();
                        finishAffinity();
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

                return true;
            case R.id.item2:
                finish();
                Intent intent = new Intent(this, MainActivity7_aboutcreator.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                finish();
                intent = new Intent(this, MainActivity6_aboutproject.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
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