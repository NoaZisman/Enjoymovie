package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.noa.enjoyamovie.MainActivity4;
import com.noa.enjoyamovie.MainActivity5;
import com.noa.enjoyamovie.MainActivity6;
import com.noa.enjoyamovie.MainActivity7;
import com.noa.enjoyamovie.Movie.Movie;
import com.noa.enjoyamovie.Movie.MovieXML;
import com.noa.enjoyamovie.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView listViewtwo;
    Intent intent;
    int i;
    LinearLayout title1;
    MyAdapter myAdapter;
    List<Movie> movieListDetails;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        intent=getIntent();
        i= intent.getIntExtra("id",0);
        builder = new AlertDialog.Builder(this);
        title1 = (LinearLayout) findViewById(R.id.title1);
        initData();
    }

    private void initData() {
        movieListDetails = new ArrayList<>();
        //if(i == 0)
        // i=who came to activity
        movieListDetails.add(new Movie("Avatar", "2022", "James Cameron", "2D,3D", "https://www.youtube.com/watch?v=d9MyW72ELq0","More than a decade after the events of the first film, 'Avatar: The Path of Water' begins to tell the story of the Sully family (Jake, Neytiri and their children), the troubles they face, the effort they make to protect each other, their struggle to stay alive and the accompanying tragedies them"));
        movieListDetails.add(new Movie("My sweet monster", "2021", "Viktor Glukhushin, Maksim Volkov", "2D", "https://www.youtube.com/watch?v=hSCqtzcMeEg","Princess Barbara has never listened to the laws: independent, rebellious who refuses to accept the decree of the law that states she must marry a prince she has never met. So she runs away from the palace to the forest, where she meets a sweet monster who guards the kingdom's forests who will help her escape and determine her own destiny"));
        movieListDetails.add(new Movie("The menu", "2022", "Mark Mylod", "2D", "https://www.youtube.com/watch?v=C_uTkUGcHv4","A young couple travels to an exclusive destination, along with a group of strangers, to eat at a restaurant on a remote island in the Pacific Ocean. There, the acclaimed and somewhat obsessive chef prepared a rich tasting menu for them, with some surprises that will leave the guests speechless"));
        movieListDetails.add(new Movie("Shotgun wedding","avatar", "imdb - 6.2", "2D", "102 min"));
        movieListDetails.add(new Movie("Beautiful desaster", "avatar", "imdb - 6.1", "2D", "130 min"));
    }
}