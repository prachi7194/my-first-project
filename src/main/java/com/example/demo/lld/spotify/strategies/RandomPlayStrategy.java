package com.example.demo.lld.spotify.strategies;

import com.example.demo.lld.spotify.models.PlayList;
import com.example.demo.lld.spotify.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RandomPlayStrategy implements IPlayStrategy {
    private PlayList currentPlayList;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private Random random;
    public RandomPlayStrategy(){
        currentPlayList = null;
        random = new Random();

    }
    @Override
    public void setPlayList(PlayList playList) {
        currentPlayList = playList;
        if(currentPlayList == null || currentPlayList.getSize() == 0){
            return;
        }
        remainingSongs = new ArrayList<>(currentPlayList.getSongList());
        history = new Stack<>();

    }

    @Override
    public Song next() {
        if (currentPlayList == null || currentPlayList.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }
        int idx = random.nextInt(remainingSongs.size());
        Song selectedSong = remainingSongs.get(idx);
        int lastIndex = remainingSongs.size() - 1;
        remainingSongs.set(idx, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);
        history.push(selectedSong);
        return selectedSong;
    }

    @Override
    public Song previous() {
        if(history.isEmpty()){
            throw new RuntimeException("No previous song available");
        }
        return history.pop();
    }

    @Override
    public boolean hasNext() {
        return currentPlayList != null && !remainingSongs.isEmpty();
    }

    @Override
    public boolean hasPrevious() {
        return history.size() > 0;
    }
}
