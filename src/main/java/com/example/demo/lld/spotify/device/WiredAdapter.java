package com.example.demo.lld.spotify.device;

import com.example.demo.lld.spotify.external.WiredSpeakerAPI;
import com.example.demo.lld.spotify.models.Song;

public class WiredAdapter implements IAudioOutputDevice {
    WiredSpeakerAPI wiredSpeakerAPI;

    public WiredAdapter(WiredSpeakerAPI wiredSpeakerAPI) {
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + "by" + song.getArtist();
        wiredSpeakerAPI.playSoundViaWired(payload);

    }
}
