package com.example.demo.lld.spotify.managers;

import com.example.demo.lld.spotify.models.PlayList;
import com.example.demo.lld.spotify.models.Song;

import java.util.HashMap;
import java.util.Map;

public class PlayListManager {
    private Map<String, PlayList> playListMap;
    private static PlayListManager instance;
    private PlayListManager(){
        instance = null;
        playListMap = new HashMap<>();
    }
    public static PlayListManager getInstance(){
        if(instance == null){
            instance = new PlayListManager();
        }
        return instance;
    }

    public void createPlayList(String name){
        if(playListMap.containsKey(name)){
            throw new RuntimeException("playlist with name " + name + "already exists ");
        }
        playListMap.put(name, new PlayList(name));
    }

    public void addSongsToPlaylist(String name, Song song){
        if(!playListMap.containsKey(name)){
            throw new RuntimeException("playlist with name " + name + "does not exists ");
        }
        playListMap.get(name).addSongToPlayList(song);
    }

    public PlayList getPlayList(String name){
        if(!playListMap.containsKey(name)){
            throw new RuntimeException("playlist with name " + name + "does not exists ");
        }
        return playListMap.get(name);
    }


}
