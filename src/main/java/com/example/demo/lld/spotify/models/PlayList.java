package com.example.demo.lld.spotify.models;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String name;
    List<Song> songList;

    public PlayList(String name) {
        this.name = name;
        this.songList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
    public int getSize(){
        return songList.size();
    }
    public void addSongToPlayList(Song song){
        if(song == null){
            throw new RuntimeException("cannot add null song to the playlist.");
        }
        songList.add(song);

    }
}
