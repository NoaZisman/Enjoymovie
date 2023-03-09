package com.noa.enjoyamovie;
import android.content.Context;
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
public class MovieAdapter extends  BaseAdapter{
    private List<Movie> movieListDetails;
    public LayoutInflater inflater;
    public MovieAdapter(Context ct, List<Movie> movieListDetails) {
        this.movieListDetails = movieListDetails;
        inflater = LayoutInflater.from(ct);
    }
    @Override
    public int getCount() {
        return movieListDetails.size();
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
        return null;
    }

    @Override
    public View getViewtwo(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.movie_details_layout,null);
        TextView name1 = view.findViewById(R.id.MovieDetailsName);
        Button url1= view.findViewById(R.id.urlLink);
        TextView yearOfPublication1 = view.findViewById(R.id.MovieDetailsYear);
        TextView director1 = view.findViewById(R.id.MovieDetailsDirector);
        TextView presentsIn1 = view.findViewById(R.id.MovieDetailsPresentIn);
        TextView summary1 = view.findViewById(R.id.MovieDetailsSummary);
        name1.setText(movieListDetails.get(i).getName());
        url1.setText(movieListDetails.get(i).getUrl());
        yearOfPublication1.setText(movieListDetails.get(i).getYearOfPublication());
        director1.setText(movieListDetails.get(i).getDirector());
        presentsIn1.setText(movieListDetails.get(i).getPresentsIn());
        summary1.setText(movieListDetails.get(i).getSummary());
        return view;
    }
}
