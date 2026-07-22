package com.example.demo.lld.moviebook;


import lld.moviebook.exceptions.InvalidRequestException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BookingSystem {



    List<Theatre> theatreList;
    HashMap<Integer, Movie> movieMap = new HashMap<>();
    HashMap<Integer, List<ShowTime>> movieIdVsShowTimeMap = new HashMap<>();
    HashMap<Integer, ShowTime> showTimeMap = new HashMap<>();
    HashMap<String, Reservation> reservationMap = new HashMap<>();




    BookingSystem(){


        theatreList = new ArrayList<>();
        for(Theatre theatre : theatreList){
            for(ShowTime showTime : theatre.getShowTimeList()){
                Movie movie = showTime.getMovie();
                movieMap.put(movie.getId(), movie);
                showTimeMap.put(showTime.getId(), showTime);
                if(movieIdVsShowTimeMap.containsKey(movie.getId())){
                    List<ShowTime> showTimes = movieIdVsShowTimeMap.get(movie.getId());
                    showTimes.add(showTime);
                    movieIdVsShowTimeMap.put(showTime.getId(), showTimes);
                }else{
                    List<ShowTime> showTimes = new ArrayList<>();
                    showTimes.add(showTime);
                    movieIdVsShowTimeMap.put(showTime.getId(), showTimes);
                }
            }
        }
    }

    public void addTheatres(Theatre theatre){
        theatreList.add(theatre);
    }

    public List<ShowTime> searchMovies(String title){
        List<ShowTime> showTimeList = new ArrayList<>();
        if(title == null || title.equals(" ")){
            return showTimeList;
        }

        for(Movie movie : movieMap.values()){
            int id = movie.getId();
            String title1 = movie.getTitle();

            if(title1.toLowerCase().equals(title)){
                List<ShowTime> times = movieIdVsShowTimeMap.get(id);
                for(ShowTime showTime:times){
                    if(showTime.getDate().isAfter(LocalDateTime.now())){
                        showTimeList.add(showTime);
                    }
                }
            }
        }
        return showTimeList;
    }

    public List<ShowTime> getShowTimesAtTheatre(Theatre theatre){
        List<ShowTime> showTimes = new ArrayList<>();
        for(ShowTime showTime : theatre.getShowTimeList()){
            if(showTime.getDate().isAfter(LocalDateTime.now())){
                showTimes.add(showTime);
            }
        }
        return showTimes;
    }
    public String bookMovie(int showTimeId, List<String> seats){
        if(showTimeId == 0 || seats == null || seats.isEmpty()){
            throw new InvalidRequestException("Request is invalid");
        }
        ShowTime showTime = showTimeMap.get(showTimeId);
        if(showTime == null){
            throw new InvalidRequestException("Showtime not found");
        }
        String confirmationId = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(confirmationId, showTime, seats);
        showTime.book(reservation);
        reservationMap.put(confirmationId, reservation);
        return confirmationId;
    }

    public void cancelReservation(String reservationId){
        if(reservationId == null){
            throw new InvalidRequestException("confirmationId is empty");
        }
        Reservation reservation = reservationMap.get(reservationId);
        if(reservation == null){
            throw new InvalidRequestException("Reservation not found");
        }
        ShowTime showTime = reservation.getShowTime();
        showTime.cancel(reservation);
        reservationMap.remove(reservationId);

    }



}
