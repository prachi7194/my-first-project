package com.example.demo.lld.spotify;

import com.example.demo.lld.spotify.enums.DeviceType;
import com.example.demo.lld.spotify.enums.PlayStrategyType;
import com.example.demo.lld.spotify.managers.PlayListManager;
import com.example.demo.lld.spotify.models.Song;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayerApplication {
    List<Song> songList;
    private static MusicPlayerApplication instance = null;
    private MusicPlayerApplication(){
        songList = new ArrayList<>();
    }
    public static synchronized MusicPlayerApplication getInstance(){
        if(instance == null){
            instance = new MusicPlayerApplication();

        }
        return instance;

    }
    public void createSong(String name, String title){
        Song song = new Song(name, title);
        songList.add(song);

    }

    public void createPlayList(String name){
        PlayListManager.getInstance().createPlayList(name);
    }

    public Song findSongByTitle(String title) {
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public void addSongToPlayList(String  playList, String title){
        Song song = findSongByTitle(title);
        if(song == null){
            throw new RuntimeException("Song \"" + title + "\" not found in library.");

        }
        PlayListManager.getInstance().addSongsToPlaylist(playList, song);
    }

    public void connectAudioDevice(DeviceType deviceType){
        MusicLayerFacade.getInstance().connectDevice(deviceType);
    }

    public void selectPlayStrategy(PlayStrategyType playStrategyType){
        MusicLayerFacade.getInstance().setPlayStrategy(playStrategyType);
    }

    public void loadPlayList(String playList){
        MusicLayerFacade.getInstance().loadPlayList(playList);
    }

    public void playSingleSong(String title){
        Song song = findSongByTitle(title);
        if (song == null) {
            throw new RuntimeException("Song \"" + title + "\" not found.");
        }
        MusicLayerFacade.getInstance().playSong(song);
    }

    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicLayerFacade.getInstance().pauseSong(song);
    }



}
