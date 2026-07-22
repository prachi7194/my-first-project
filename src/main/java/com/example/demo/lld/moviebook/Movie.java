package com.example.demo.lld.moviebook;


public class Movie {
    private String title;
    private int id;

    public Movie() {
    }

    public Movie(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public int getId() {
        return id;
    }

}
