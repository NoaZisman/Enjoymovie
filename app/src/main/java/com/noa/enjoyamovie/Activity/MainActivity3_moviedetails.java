package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.noa.enjoyamovie.IncomingCall_Reciver;
import com.noa.enjoyamovie.Movie.Movie;
import com.noa.enjoyamovie.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3_moviedetails extends AppCompatActivity {
    ListView listViewtwo;
    Intent intent;
    int i;
    LinearLayout title1;
    MyAdapter myAdapter;
    List<Adult> movieListDetails;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        intent=getIntent();
        i= intent.getIntExtra("id",0);
        builder = new AlertDialog.Builder(this);
        title1 = (LinearLayout) findViewById(R.id.title1);
        initData();

        TextView name = findViewById(R.id.MovieDetailsName);
        name.setText(movieListDetails.get(i).getName());
        TextView details = findViewById(R.id.MovieDetailsSummary);
        details.setText(movieListDetails.get(i).getSummary());


    }

    private void initData() {
        movieListDetails = new ArrayList<>();
        //if(i == 0)
        // i=who came to activity
        movieListDetails.add(new Adult("Avatar", "2022", "James Cameron", "2D,3D", "https://www.youtube.com/watch?v=d9MyW72ELq0","no","More than a decade after the events of the first film, 'Avatar: The Path of Water' begins to tell the story of the Sully family (Jake, Neytiri and their children), the troubles they face, the effort they make to protect each other, their struggle to stay alive and the accompanying tragedies them"));
        movieListDetails.add(new Adult("My sweet monster", "2021", "Viktor Glukhushin, Maksim Volkov", "2D", "https://www.youtube.com/watch?v=hSCqtzcMeEg","no","Princess Barbara has never listened to the laws: independent, rebellious who refuses to accept the decree of the law that states she must marry a prince she has never met. So she runs away from the palace to the forest, where she meets a sweet monster who guards the kingdom's forests who will help her escape and determine her own destiny"));
        movieListDetails.add(new Adult("The menu", "2022", "Mark Mylod", "2D", "https://www.youtube.com/watch?v=C_uTkUGcHv4","no","A young couple travels to an exclusive destination, along with a group of strangers, to eat at a restaurant on a remote island in the Pacific Ocean. There, the acclaimed and somewhat obsessive chef prepared a rich tasting menu for them, with some surprises that will leave the guests speechless"));
        movieListDetails.add(new Adult("Shotgun wedding","2023", "Jason Moore", "2D", "https://www.youtube.com/watch?v=U8gz0rUzTAY","no","Darcy and Tom are going to get married. Tom arranges for the wedding to take place in Bali, so that their families will be reunited together in an exotic destination. As Darcy and Tom begin to get cold feet about the wedding, their troubles worsen when the wedding guests are taken prisoner by a group of pirates"));
        movieListDetails.add(new Adult("Beautiful desaster", "2023", "Roger Kumble", "2D", "https://www.youtube.com/watch?v=ypQ-CoB6WY0","yes","Beautiful Disaster is a romantic drama based on the bestselling novel of the same name by Jamie McGuire and follows Abby, a freshman who falls in love against the odds with college bad boy Travis Maddox, whom she would rather avoid"));
        movieListDetails.add(new Adult("Puss in boots 2", "2011", "Chris Miller", "2D", "https://www.youtube.com/watch?v=1esRrwrmWzA","no","Long before he even met Shrek, the infamous warrior, lover and criminal - 'Puss in Boots' becomes a hero. This happens when he goes on an adventure with the tough and vigilant kitty Kitty 'Softfox' and Humpty Dumpty in order to save his city. Along the way, entanglements and difficulties await them in the form of the pair of villains Jack and Jill who will do everything in their power to thwart the cat and his friends in their mission"));
        movieListDetails.add(new Adult("Puss in boots", "2023", "Joel Crawford", "2D", "https://www.youtube.com/watch?v=RqrXhwS33yc","no","The legendary world of Shrek finally returns to the cinema in a new adventure about Puss in Boots: the world famous Puss discovers that nine souls - he has only one and last soul left. He embarks on a funny and crazy journey through the world of fairy tales to get the wishing star and make just one more wish"));
        movieListDetails.add(new Adult("Alvin and the chipmanks", "2011", "Mike Mitchell", "2D", "https://www.youtube.com/watch?v=-dOc_fqmcZo", "no","They discover their new turf is not as deserted as it seems. Playing around while aboard a cruise ship, the Chipmunks and Chipettes accidentally go overboard and end up marooned in a tropical paradise"));
    }
}