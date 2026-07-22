package com.example.demo.lld.moviebook;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int id;
    private String name;
    private List<ShowTime> showTimeList;

    public Theatre(String name, int id){
        this.name = name;
        this.id = id;
        showTimeList = new ArrayList<>();
    }

    public List<ShowTime> getShowTimeList() {
        return showTimeList;
    }

    public List<ShowTime> getShowTimeForMovie(Movie movie){
        List<ShowTime> particular = new ArrayList<>();
        for(ShowTime showTime : showTimeList){
           if(showTime.getMovie().getId() == movie.getId()){
               particular.add(showTime);
           }
        }
        return particular;
    }
}
