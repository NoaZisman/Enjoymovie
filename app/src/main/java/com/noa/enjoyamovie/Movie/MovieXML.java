package com.noa.enjoyamovie.Movie;
import android.graphics.drawable.Drawable;
import android.media.Image;

public class MovieXML {
    private String name;
    private int image;
    private String imdb;
    private String type;
    private String time;

    public MovieXML(String name, int image, String imdb, String type, String time) {
        this.name = name;
        this.image = image;
        this.imdb = imdb;
        this.type = type;
        this.time = time;
    }

    //region getters with setters
    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getImdb() {
        return imdb;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //endregion


    @Override
    public String toString() {
        return "MovieXML{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", imdb='" + imdb + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

