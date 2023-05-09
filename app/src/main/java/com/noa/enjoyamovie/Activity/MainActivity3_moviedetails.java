package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.noa.enjoyamovie.IncomingCall_Reciver;
import com.noa.enjoyamovie.MainActivity4_movies;
import com.noa.enjoyamovie.Movie.Movie;
import com.noa.enjoyamovie.MyService;
import com.noa.enjoyamovie.R;
import com.noa.enjoyamovie.SensorLightHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity3_moviedetails extends AppCompatActivity {
    ListView listViewtwo;
    Intent intent;
    int i;
    Button toorder;
    Button back;
    LinearLayout title1;
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    MyAdapter myAdapter;
    List<Movie> movieListDetails;
    AlertDialog.Builder builder;
    Button CalendarView;
    int year11;
    int month1;
    int day1;
    int hour1;
    int minute1;
    Spinner spinner;
    DatePickerDialog.OnDateSetListener datepicker;
    Intent intent2;
    String username;
    String password;
    String id;
    private SensorLightHandler mSensorLightHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);

        intent=getIntent();
        i= intent.getIntExtra("id",0);
        builder = new AlertDialog.Builder(this);
        playtv = (TextView) this.findViewById(R.id.playtv);
        stoptv = (TextView) this.findViewById(R.id.stoptv);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        title1 = (LinearLayout) findViewById(R.id.title1);
        toorder = (Button) findViewById(R.id.toorder);
        back = (Button) findViewById(R.id.back);
        CalendarView = (Button) findViewById(R.id.CalendarView);
        back.setOnClickListener(this::Click1);
        toorder.setOnClickListener(this::Click2);
        play.setOnClickListener(this::Click3);
        stop.setOnClickListener(this::Click4);
        spinner = findViewById(R.id.spinner);
        initData();

        Button url1=findViewById(R.id.MovieDetailsurl);
        TextView name1 = findViewById(R.id.MovieDetailsName);
        TextView MovieDetailsDirectorTv=findViewById(R.id.MovieDetailsDirectorTv);
        TextView MovieDetailsYearTv=findViewById(R.id.MovieDetailsYearTv);
        TextView MovieDetailsPresentInTv=findViewById(R.id.MovieDetailsPresentInTv);
        name1.setText(movieListDetails.get(i).getName());
        TextView sum1 = findViewById(R.id.MovieDetailsSummary);
        sum1.setText(movieListDetails.get(i).getSummary());
        TextView director1 = findViewById(R.id.MovieDetailsDirector);
        director1.setText(movieListDetails.get(i).getDirector());
        TextView year1 = findViewById(R.id.MovieDetailsYear);
        year1.setText(movieListDetails.get(i).getYearOfPublication());
        TextView presentIn1 = findViewById(R.id.MovieDetailsPresentIn);
        presentIn1.setText(movieListDetails.get(i).getPresentsIn());
        TextView adultContentOnly1 = findViewById(R.id.MovieDetailsadultContentOnly);
        if(movieListDetails.get(i) instanceof Adult)
        {
            adultContentOnly1.setText("this movie is only for adults and it's genre is: "+((Adult)movieListDetails.get(i)).getTypeMovie());
        }

        Calendar calendar=Calendar.getInstance();
        year11 =calendar.get(Calendar.YEAR);
        month1 =calendar.get(Calendar.MONTH);
        day1 =calendar.get(Calendar.DAY_OF_MONTH);
        hour1=calendar.get(Calendar.HOUR_OF_DAY);
        minute1=calendar.get(Calendar.MINUTE);
        CalendarView.setOnClickListener(this::Click5);
        url1.setOnClickListener(this::Click6);
    }

    private void initData() {
        //מוסיפה את העצמים של הסרטים לרשימה
        movieListDetails = new ArrayList<>();
        movieListDetails.add(new Movie("Avatar", "2022", "James Cameron", "2D", "https://www.youtube.com/watch?v=d9MyW72ELq0","More than a decade after the events of the first film, 'Avatar: The Path of Water' begins to tell the story of the Sully family (Jake, Neytiri and their children), the troubles they face, the effort they make to protect each other, their struggle to stay alive and the accompanying tragedies them."));
        movieListDetails.add(new Movie("My sweet monster", "2021", "Viktor Glukhushin, Maksim Volkov", "2D", "https://www.youtube.com/watch?v=hSCqtzcMeEg","Princess Barbara has never listened to the laws: independent, rebellious who refuses to accept the decree of the law that states she must marry a prince she has never met. So she runs away from the palace to the forest, where she meets a sweet monster who guards the kingdom's forests who will help her escape and determine her own destiny."));
        movieListDetails.add(new Adult("The menu", "2022", "Mark Mylod", "2D", "https://www.youtube.com/watch?v=C_uTkUGcHv4","A young couple travels to an exclusive destination, along with a group of strangers, to eat at a restaurant on a remote island in the Pacific Ocean. There, the acclaimed and somewhat obsessive chef prepared a rich tasting menu for them, with some surprises that will leave the guests speechless.","horror"));
        movieListDetails.add(new Adult("Shotgun wedding","2023", "Jason Moore", "2D", "https://www.youtube.com/watch?v=U8gz0rUzTAY","Darcy and Tom are going to get married. Tom arranges for the wedding to take place in Bali, so that their families will be reunited together in an exotic destination. As Darcy and Tom begin to get cold feet about the wedding, their troubles worsen when the wedding guests are taken prisoner by a group of pirates.","action"));
        movieListDetails.add(new Adult("Beautiful desaster", "2023", "Roger Kumble", "2D", "https://www.youtube.com/watch?v=l4h6dixgn9E","Beautiful Disaster is a romantic drama based on the bestselling novel of the same name by Jamie McGuire and follows Abby, a freshman who falls in love against the odds with college bad boy Travis Maddox, whom she would rather avoid.","drama"));
        movieListDetails.add(new Movie("Puss in boots", "2023", "Joel Crawford", "2D", "https://www.youtube.com/watch?v=RqrXhwS33yc","The legendary world of Shrek finally returns to the cinema in a new adventure about Puss in Boots: the world famous Puss discovers that nine souls - he has only one and last soul left. He embarks on a funny and crazy journey through the world of fairy tales to get the wishing star and make just one more wish."));
        movieListDetails.add(new Movie("Puss in boots 2", "2011", "Chris Miller", "2D", "https://www.youtube.com/watch?v=1esRrwrmWzA","Long before he even met Shrek, the infamous warrior, lover and criminal - 'Puss in Boots' becomes a hero. This happens when he goes on an adventure with the tough and vigilant kitty Kitty 'Softfox' and Humpty Dumpty in order to save his city. Along the way, entanglements and difficulties await them in the form of the pair of villains Jack and Jill who will do everything in their power to thwart the cat and his friends in their mission."));
        movieListDetails.add(new Movie("Alvin and the chipmanks", "2011", "Mike Mitchell", "2D", "https://www.youtube.com/watch?v=-dOc_fqmcZo","They discover their new turf is not as deserted as it seems. Playing around while aboard a cruise ship, the Chipmunks and Chipettes accidentally go overboard and end up marooned in a tropical paradise."));
        movieListDetails.add(new Movie("Cinderella", "1950", "Wilfred Jackson, Hamilton Luske, Clyde Geronimi", "2D", "https://www.youtube.com/watch?v=UcjYD91YW_M","Cinderella is living happily with her mother and father until her mother dies. Her father remarries a cruel woman who has two daughters. Her father dies, Cinderella turns into a virtual servant in her own house. Meanwhile, the King invites every eligible maiden in the kingdom to a fancy dress ball. Cinderella has no suitable dress for a ball, but her friends the mice and the birds lend a hand in making her one.At this point, enter the Fairy Godmother, the pumpkin carriage, the royal ball, and the rest, as they say, is fairy tale history."));
        movieListDetails.add(new Movie("The little mermaid", "1989", "John Musker, Ron Clements", "2D", "https://www.youtube.com/watch?v=nPE0f-MB_bQ","Somewhere under the surface of the sea, beyond the limits of the imagination, a whole kingdom of fantasy extends to her! A stubborn mermaid named Ariel falls in love with a handsome human prince and longs to set sail. With the help of her friends the shy and golden-hearted Flounder and Sebastian, the reggae-singing scorpion, Ariel emerges from the depths of the sea to try to win her lover's heart."));

    }

    public void Click1(View v) {
        //הפעולה מעבירה את המשתמש למסך הראשי עם הסרטים
        finish();
        Intent intent = new Intent(this, MainActivity4_movies.class);
        startActivity(intent);
    }
    public void Click2(View v) {
        //הפעולה מעבירה נתונים ואת המשתמש למסך בחירת המקומות ישיבה
        intent2 = getIntent();
        username= intent2.getStringExtra("username");
        password= intent2.getStringExtra("password");
        id = intent2.getStringExtra("iduser");
        Intent intent = new Intent(this, MainActivity2_seatselection.class);
        intent.putExtra("name",movieListDetails.get(i).getName());

        if(dateTxt == null || dateTxt.isEmpty()){
            //הפעולה בודקת אם המשתמש בחר תאריך
            Toast.makeText(getApplicationContext(),"Choose date first",Toast.LENGTH_SHORT).show();
            return;
        }
        if(spinner.getSelectedItem()==null){
            //הפעולה בודקת שהמשתמש בחר שעה
            Toast.makeText(getApplicationContext(),"Choose time first",Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("time",spinner.getSelectedItem().toString());
        intent.putExtra("date",dateTxt);
        intent.putExtra("username",username);
        intent.putExtra("password",password);
        intent.putExtra("iduser",id);
        finish();
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

String dateTxt;
    public void Click5(View v)
    {
        //הפעולה מגדירה את טווח הבחירה של המשתמש לתאריך
        Calendar calmax = Calendar.getInstance();
        calmax.set(calmax.get(Calendar.YEAR),calmax.get(Calendar.MONTH),calmax.get(Calendar.DAY_OF_MONTH)+7,
                calmax.get(Calendar.HOUR_OF_DAY), calmax.get(Calendar.MINUTE), 0);
        long timemax = calmax.getTimeInMillis();

        Calendar calmin = Calendar.getInstance();
        calmin.set(calmin.get(Calendar.YEAR),calmin.get(Calendar.MONTH),calmin.get(Calendar.DAY_OF_MONTH),
                calmin.get(Calendar.HOUR_OF_DAY), calmin.get(Calendar.MINUTE), 0);
        long timemin = calmin.getTimeInMillis();
        datepicker=new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {

                if((year>=year11 && month>=month1 && dayOfMonth>=day1) || (year>year11 && month<=month1 && dayOfMonth<=day1) || (year>year11 && month>=month1 && dayOfMonth<=day1) ||(year>year11 && month>=month1 && dayOfMonth>=day1)||(year>year11 && month<=month1 && dayOfMonth>=day1))
                {

                    month = month + 1;
                    dateTxt = dayOfMonth + "/" + month + "/" + year;

                }

            }
        };

        DatePickerDialog datePickerDialog =new DatePickerDialog(MainActivity3_moviedetails.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,datepicker,year11,month1,day1);
        datePickerDialog.getWindow().setBackgroundDrawableResource(R.drawable.flower);
        datePickerDialog.getDatePicker().setMaxDate(timemax);
        datePickerDialog.getDatePicker().setMinDate(timemin);
        datePickerDialog.show();

    }
    public void Click6(View v) {
//הפעולה מקבלת את הסטרינג של הקישור ליוטיוב מהמסך של הנתונים על סרט ספציפי ומעבירה אותו לפעולה שפותחת את הקישור
        intent=getIntent();
        i= intent.getIntExtra("id",0);
        gotoUrl(movieListDetails.get(i).getUrl());
    }

    private void gotoUrl(String url) {
        //הפעולה מעבירה את המשתמש לטריילר ביוטיוב
        Uri uri= Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
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