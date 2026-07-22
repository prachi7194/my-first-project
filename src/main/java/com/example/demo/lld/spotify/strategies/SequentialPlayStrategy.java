package com.example.demo.lld.spotify.strategies;

import lld.spotify.models.PlayList;
import lld.spotify.models.Song;

public class SequentialPlayStrategy implements IPlayStrategy {
    private PlayList currentPlayList;
    int currentIndex;
    public SequentialPlayStrategy(){
        currentPlayList = null;
        currentIndex = -1;
    }
    @Override
    public void setPlayList(PlayList playList) {

        currentPlayList = null;
        currentIndex = -1;
    }

    @Override
    public Song next() {
        if(currentPlayList == null && currentPlayList.getSize() == 0){
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }
        currentIndex = currentIndex + 1;
        return currentPlayList.getSongList().get(currentIndex);
    }

    @Override
    public Song previous() {
        if(currentPlayList == null && currentPlayList.getSize() == 0){
            throw new RuntimeException("no playlist loaded or playlist is empty");
        }
        currentIndex = currentIndex - 1;
        return currentPlayList.getSongList().get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return (currentIndex + 1) < currentPlayList.getSize();
    }

    @Override
    public boolean hasPrevious() {
        return (currentIndex - 1) >= 0;
        //remove =zero and see what happens
    }
}
