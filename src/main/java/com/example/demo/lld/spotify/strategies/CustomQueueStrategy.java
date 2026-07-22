package com.example.demo.lld.spotify.strategies;

import com.example.demo.lld.spotify.models.PlayList;
import com.example.demo.lld.spotify.models.Song;

public class CustomQueueStrategy implements IPlayStrategy {
    //implement as per the usecase
    @Override
    public void setPlayList(PlayList playList) {

    }

    @Override
    public Song next() {
        return null;
    }

    @Override
    public Song previous() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public void addToNext(Song song) {
        IPlayStrategy.super.addToNext(song);
    }
}
