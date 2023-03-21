package com.noa.enjoyamovie.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.noa.enjoyamovie.Movie.Movie;
import com.noa.enjoyamovie.Movie.MovieXML;
import com.noa.enjoyamovie.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<MovieXML> movieList;
    public LayoutInflater inflater;
    public MyAdapter(Context ct, List<MovieXML> movieList) {
        this.movieList = movieList;
        inflater = LayoutInflater.from(ct);
    }


    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.movie_layout,null);
        TextView name1 = view.findViewById(R.id.MovieName);
        ImageView image1= view.findViewById(R.id.imageview);
        TextView imdb1 = view.findViewById(R.id.MovieImdb);
        TextView type1 = view.findViewById(R.id.MovieShowType);
        TextView price1 = view.findViewById(R.id.MoviePrice);
        TextView time1 = view.findViewById(R.id.MovieLength);
        name1.setText(movieList.get(i).getName());
        image1.setImageResource(movieList.get(i).getImage());
        imdb1.setText(movieList.get(i).getImdb());
        type1.setText(movieList.get(i).getType());
        time1.setText(movieList.get(i).getTime());

        return view;
    }

}
