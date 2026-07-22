package com.example.demo.lld.spotify.device;

import com.example.demo.lld.spotify.external.HeadphonesAPI;
import com.example.demo.lld.spotify.models.Song;

public class HeadphonesAdapter implements IAudioOutputDevice {
    HeadphonesAPI headphonesAPI;

    public HeadphonesAdapter(HeadphonesAPI headphonesAPI) {
        this.headphonesAPI = headphonesAPI;
    }


    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + "by" + song.getArtist();
        headphonesAPI.playSoundViaHeadphones(payload);

    }
}
