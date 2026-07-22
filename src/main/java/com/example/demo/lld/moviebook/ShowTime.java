package com.example.demo.lld.moviebook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShowTime {
    private int id;
    private Theatre theatre;
    private Movie movie;
    private LocalDateTime dateTime;
    private List<Reservation> reservations;

    public int getId(){
        return id;
    }

    public ShowTime(int id, Theatre theatre, Movie movie, LocalDateTime dateTime) {
        this.id = id;
        this.theatre = theatre;
        this.movie = movie;
        this.dateTime = dateTime;
        this.reservations = new ArrayList<>();
    }


    public Movie getMovie(){
        return this.movie;
    }

    public LocalDateTime getDate(){
        return dateTime;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public boolean isAvailable(String seatId){
        for(Reservation reservation : reservations){
            if(reservation.getSeats().contains(seatId)){
                return false;
            }
        }
        return true;
    }

    public List<String> getAvailableSeats(){
        Set<String> booked = new HashSet<>();
        for(Reservation reservation : reservations){
            booked.addAll(reservation.getSeats());
        }
        List<String> available = new ArrayList<>();
        for(char row = 'A';row <= 'Z'; row++){
            for(int num = 0; num < 20; num++){
                String seatId = "" + row + num;
                if(!booked.contains(seatId)){
                    available.add(seatId);
                }
            }
        }
        return available;
    }

    public void book(Reservation reservation) {
        synchronized (this){
            List<String> seatIds = reservation.getSeats();
            if(seatIds == null && seatIds.isEmpty()){
                throw new IllegalArgumentException("must select atleast one seat");
            }
            for(String seatId: seatIds){
                if(!isAvailable(seatId)){
                    throw new IllegalArgumentException("seat is already booked "+seatId);
                }
            }
            reservations.add(reservation);
        }
    }

    public void cancel(Reservation reservation) {
        synchronized (this){
            reservations.remove(reservation);
        }
    }
}
