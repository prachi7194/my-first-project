package com.example.demo.lld.spotify.device;

import lld.spotify.models.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
