package com.noa.enjoyamovie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.noa.enjoyamovie.Activity.MainActivity3;
import com.noa.enjoyamovie.Activity.MyAdapter;
import com.noa.enjoyamovie.MainActivity4;
import com.noa.enjoyamovie.MainActivity5;
import com.noa.enjoyamovie.MainActivity6;
import com.noa.enjoyamovie.MainActivity7;
import com.noa.enjoyamovie.R;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.noa.enjoyamovie.Movie.MovieXML;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ListView listView;
    LinearLayout title1;
    LinearLayoutManager linearLayoutManager;
    List<MovieXML> movieList;
    MyAdapter myAdapter;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        builder = new AlertDialog.Builder(this);
        title1 = (LinearLayout) findViewById(R.id.title1);
        initData();
        initRecyclerView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieXML v = movieList.get(i);

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("id", i);
                startActivityForResult(intent, 1);
            }
        });
    }
    private void initData() {
        movieList = new ArrayList<>();
        movieList.add(new MovieXML("Avatar", R.drawable.movie_image_avatar, "imdb - 7.9", "2D,3D", "192 min"));
        movieList.add(new MovieXML("My sweet monster", R.drawable.movie_image_mysweetmonster, "imdb - 4.9", "2D", "98 min"));
        movieList.add(new MovieXML("The menu", R.drawable.movie_image_themenu, "imdb - 7.3", "2D", "106 min"));
        movieList.add(new MovieXML("Shotgun wedding", R.drawable.movie_image_shotgunwedding, "imdb - 6.2", "2D", "102 min"));
        movieList.add(new MovieXML("Beautiful desaster", R.drawable.movie_image_beautifuldesaster, "imdb - 6.1", "2D", "130 min"));
    }

    private void initRecyclerView() {
        listView = findViewById(R.id.listView);
        myAdapter = new MyAdapter(getApplicationContext(), movieList);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }



}