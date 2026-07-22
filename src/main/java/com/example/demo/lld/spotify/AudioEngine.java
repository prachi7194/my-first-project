package com.example.demo.lld.spotify;

import com.example.demo.lld.spotify.device.IAudioOutputDevice;
import com.example.demo.lld.spotify.models.Song;

public class AudioEngine {
    private Song currentSong;
    private boolean isSongPaused;
    public AudioEngine(){
        currentSong = null;
        isSongPaused = false;
    }
    public String getCurrentSongTitle(){
        if(currentSong != null){
            return currentSong.getTitle();
        }
        return "";
    }

    public boolean isSongPaused(){
        return isSongPaused;
    }

    public void play(IAudioOutputDevice iAudioOutputDevice, Song song){
        if(song == null){
            throw new RuntimeException("cannot play null song");
        }
        if(isSongPaused && currentSong == song){
            isSongPaused = false;
            System.out.println("Resuming song: " + song.getTitle());
            iAudioOutputDevice.playAudio(song);
            return;
        }
        currentSong = song;
        isSongPaused = false;
        iAudioOutputDevice.playAudio(song);
    }

    public void pause(){
        if (currentSong == null) {
            throw new RuntimeException("No song is currently playing to pause.");
        }
        if (isSongPaused) {
            throw new RuntimeException("Song is already paused.");
        }
        isSongPaused = true;
        System.out.println("Pausing song: " + currentSong.getTitle());
    }
}
