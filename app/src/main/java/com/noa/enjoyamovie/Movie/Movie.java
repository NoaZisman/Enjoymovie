package com.noa.enjoyamovie.Movie;
public class Movie {
    String name;
    String yearOfPublication;
    String director;
    String presentsIn;
    String url;
    String summary;
    public Movie(String name,String yearOfPublication,String director,String presentsIn, String url, String summary)
    {
        this.name=name;
        this.yearOfPublication=yearOfPublication;
        this.director=director;
        this.presentsIn=presentsIn;
        this.url=url;
        this.summary=summary;
    }

    public String getName() {
        return name;
    }
    public String getYearOfPublication() {
        return yearOfPublication;
    }
    public String getDirector() {
        return director;
    }
    public String getPresentsIn() {
        return presentsIn;
    }
    public String getUrl() {
        return url;
    }
    public String getSummary() {
        return summary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setPresentsIn(String presentsIn) {
        this.presentsIn = presentsIn;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", director='" + director + '\'' +
                ", presentsIn='" + presentsIn + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
