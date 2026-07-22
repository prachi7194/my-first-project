package com.example.demo.lld.spotify.device;

import lld.spotify.external.HeadphonesAPI;
import lld.spotify.models.Song;

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
