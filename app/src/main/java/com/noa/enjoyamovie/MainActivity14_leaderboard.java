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

import com.noa.enjoyamovie.Movie.Movie;

import java.util.ArrayList;

public class MainActivity14_leaderboard extends AppCompatActivity {
    Button play;
    Button stop;
    TextView playtv;
    TextView stoptv;
    TextView title;
    TextView titletwo;
    AlertDialog.Builder builder;
    Kids[]arr=new Kids[8];
   /* arr[0]=("Avatar", "2022", "James Cameron", "2D,3D", "https://www.youtube.com/watch?v=d9MyW72ELq0","More than a decade after the events of the first film, 'Avatar: The Path of Water' begins to tell the story of the Sully family (Jake, Neytiri and their children), the troubles they face, the effort they make to protect each other, their struggle to stay alive and the accompanying tragedies them","yes");
    arr[1]=("My sweet monster", "2021", "Viktor Glukhushin, Maksim Volkov", "2D", "https://www.youtube.com/watch?v=hSCqtzcMeEg","Princess Barbara has never listened to the laws: independent, rebellious who refuses to accept the decree of the law that states she must marry a prince she has never met. So she runs away from the palace to the forest, where she meets a sweet monster who guards the kingdom's forests who will help her escape and determine her own destiny","yes");
    arr[2]=("The menu", "2022", "Mark Mylod", "2D", "https://www.youtube.com/watch?v=C_uTkUGcHv4","A young couple travels to an exclusive destination, along with a group of strangers, to eat at a restaurant on a remote island in the Pacific Ocean. There, the acclaimed and somewhat obsessive chef prepared a rich tasting menu for them, with some surprises that will leave the guests speechless","no"));
    arr[3]=("Shotgun wedding","2023", "Jason Moore", "2D", "https://www.youtube.com/watch?v=U8gz0rUzTAY","no","Darcy and Tom are going to get married. Tom arranges for the wedding to take place in Bali, so that their families will be reunited together in an exotic destination. As Darcy and Tom begin to get cold feet about the wedding, their troubles worsen when the wedding guests are taken prisoner by a group of pirates","no"));
    arr[4]=("Beautiful desaster", "2023", "Roger Kumble", "2D", "https://www.youtube.com/watch?v=ypQ-CoB6WY0","Beautiful Disaster is a romantic drama based on the bestselling novel of the same name by Jamie McGuire and follows Abby, a freshman who falls in love against the odds with college bad boy Travis Maddox, whom she would rather avoid","no"));
    arr[5]=("Puss in boots 2", "2011", "Chris Miller", "2D", "https://www.youtube.com/watch?v=1esRrwrmWzA","Long before he even met Shrek, the infamous warrior, lover and criminal - 'Puss in Boots' becomes a hero. This happens when he goes on an adventure with the tough and vigilant kitty Kitty 'Softfox' and Humpty Dumpty in order to save his city. Along the way, entanglements and difficulties await them in the form of the pair of villains Jack and Jill who will do everything in their power to thwart the cat and his friends in their mission","yes"));
    arr[6]=("Puss in boots", "2023", "Joel Crawford", "2D", "https://www.youtube.com/watch?v=RqrXhwS33yc","The legendary world of Shrek finally returns to the cinema in a new adventure about Puss in Boots: the world famous Puss discovers that nine souls - he has only one and last soul left. He embarks on a funny and crazy journey through the world of fairy tales to get the wishing star and make just one more wish","yes"));
    arr[7]=("Alvin and the chipmanks", "2011", "Mike Mitchell", "2D", "https://www.youtube.com/watch?v=-dOc_fqmcZo","They discover their new turf is not as deserted as it seems. Playing around while aboard a cruise ship, the Chipmunks and Chipettes accidentally go overboard and end up marooned in a tropical paradise","yes"));
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14_leaderboard);
        IncomingCall_Reciver myReceiver;
        IntentFilter filter;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},1);
        myReceiver=new IncomingCall_Reciver();
        filter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(myReceiver,filter);
        playtv = (TextView) findViewById(R.id.playtv);
        stoptv = (TextView) findViewById(R.id.stoptv);
        title = (TextView) findViewById(R.id.title);
        titletwo = (TextView) findViewById(R.id.titletwo);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        builder = new AlertDialog.Builder(this);
        play.setOnClickListener(this::Click3);

        stop.setOnClickListener(this::Click4);

    }
    public void Click1(View v) {
       /* arr[0]=("Avatar", "2022", "James Cameron", "2D,3D", "https://www.youtube.com/watch?v=d9MyW72ELq0","More than a decade after the events of the first film, 'Avatar: The Path of Water' begins to tell the story of the Sully family (Jake, Neytiri and their children), the troubles they face, the effort they make to protect each other, their struggle to stay alive and the accompanying tragedies them","yes");
        arr[1]=("My sweet monster", "2021", "Viktor Glukhushin, Maksim Volkov", "2D", "https://www.youtube.com/watch?v=hSCqtzcMeEg","Princess Barbara has never listened to the laws: independent, rebellious who refuses to accept the decree of the law that states she must marry a prince she has never met. So she runs away from the palace to the forest, where she meets a sweet monster who guards the kingdom's forests who will help her escape and determine her own destiny","yes");
        arr[2]=("The menu", "2022", "Mark Mylod", "2D", "https://www.youtube.com/watch?v=C_uTkUGcHv4","A young couple travels to an exclusive destination, along with a group of strangers, to eat at a restaurant on a remote island in the Pacific Ocean. There, the acclaimed and somewhat obsessive chef prepared a rich tasting menu for them, with some surprises that will leave the guests speechless","no"));
        arr[3]=("Shotgun wedding","2023", "Jason Moore", "2D", "https://www.youtube.com/watch?v=U8gz0rUzTAY","no","Darcy and Tom are going to get married. Tom arranges for the wedding to take place in Bali, so that their families will be reunited together in an exotic destination. As Darcy and Tom begin to get cold feet about the wedding, their troubles worsen when the wedding guests are taken prisoner by a group of pirates","no"));
        arr[4]=("Beautiful desaster", "2023", "Roger Kumble", "2D", "https://www.youtube.com/watch?v=ypQ-CoB6WY0","Beautiful Disaster is a romantic drama based on the bestselling novel of the same name by Jamie McGuire and follows Abby, a freshman who falls in love against the odds with college bad boy Travis Maddox, whom she would rather avoid","no"));
        arr[5]=("Puss in boots 2", "2011", "Chris Miller", "2D", "https://www.youtube.com/watch?v=1esRrwrmWzA","Long before he even met Shrek, the infamous warrior, lover and criminal - 'Puss in Boots' becomes a hero. This happens when he goes on an adventure with the tough and vigilant kitty Kitty 'Softfox' and Humpty Dumpty in order to save his city. Along the way, entanglements and difficulties await them in the form of the pair of villains Jack and Jill who will do everything in their power to thwart the cat and his friends in their mission","yes"));
        arr[6]=("Puss in boots", "2023", "Joel Crawford", "2D", "https://www.youtube.com/watch?v=RqrXhwS33yc","The legendary world of Shrek finally returns to the cinema in a new adventure about Puss in Boots: the world famous Puss discovers that nine souls - he has only one and last soul left. He embarks on a funny and crazy journey through the world of fairy tales to get the wishing star and make just one more wish","yes"));
        arr[7]=("Alvin and the chipmanks", "2011", "Mike Mitchell", "2D", "https://www.youtube.com/watch?v=-dOc_fqmcZo","They discover their new turf is not as deserted as it seems. Playing around while aboard a cruise ship, the Chipmunks and Chipettes accidentally go overboard and end up marooned in a tropical paradise","yes"));
   */


    }

    //לעשות כמו שעשינו בגן חיות וכזה שיש פעולה שמוצאת רק איבר ספציפי מהעצם ואת כל הנתונים שלו אז ככה למצוא את הסרטים רק לילדים
    public void Click3(View v) {
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
        Intent music=new Intent(getApplicationContext(),MyService.class);
        stopService(music);
    }
}