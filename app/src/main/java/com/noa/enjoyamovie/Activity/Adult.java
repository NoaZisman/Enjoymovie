package com.noa.enjoyamovie.Activity;

import com.noa.enjoyamovie.Movie.Movie;

public class Adult extends Movie {
    private String typeMovie;

    public Adult(String name, String yearOfPublication, String director, String presentsIn, String url, String summary, String typeMovie) {
        super(name, yearOfPublication, director, presentsIn, url, summary);
        this.typeMovie = typeMovie;
    }
    public String getTypeMovie() {
        return typeMovie;
    }
    public void setTypeMovie(String typeMovie) {
        this.typeMovie = typeMovie;
    }

    @Override
    public String toString()
    {
        return super.toString() + " ,movie type:" + this.typeMovie;
    }
}
