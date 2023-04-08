package com.noa.enjoyamovie.Activity;

import com.noa.enjoyamovie.Movie.Movie;

public class Adult extends Movie {
    private String adultContentOnly;

    public Adult(String name, String yearOfPublication, String director, String presentsIn, String url, String adultContentOnly, String summary) {
        super(name, yearOfPublication, director, presentsIn, url, summary);
        this.adultContentOnly = adultContentOnly;
    }
    public String getAdultContentOnly() {
        return adultContentOnly;
    }
    public void setAdultContentOnly(String adultContentOnly) {
        this.adultContentOnly = adultContentOnly;
    }

    @Override
    public String toString()
    {
        return super.toString() + " ,adult content only:" + this.adultContentOnly;
    }
}
