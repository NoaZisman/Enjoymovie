package com.noa.enjoyamovie;

import com.noa.enjoyamovie.Movie.Movie;

public class Kids extends Movie {
   private String animation;

    public Kids(String name, String yearOfPublication, String director, String presentsIn, String url,String summary, String animation) {
        super(name, yearOfPublication, director, presentsIn, url, summary);
        this.animation = animation;
    }

    public String getAnimation() {
        return animation;
    }
    public void setAnimation(String animation) {
        this.animation = animation;
    }

    @Override
    public String toString()
    {
        return super.toString() + " ,animation:" + this.animation;
    }
}
