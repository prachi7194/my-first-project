package com.example.demo.lld.moviebook;

import java.util.List;

public class Reservation {
    private String confirmationId;
    private ShowTime showTime;

    public List<String> getSeats() {
        return seats;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public Reservation(String confirmationId, ShowTime showTime, List<String> seats) {
        this.confirmationId = confirmationId;
        this.showTime = showTime;
        this.seats = seats;
    }

    public String getConfirmationId() {
        return confirmationId;
    }

    private List<String> seats;
}
