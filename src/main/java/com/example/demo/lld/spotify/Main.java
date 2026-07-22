package com.example.demo.lld.spotify;

import com.example.demo.lld.spotify.enums.DeviceType;

public class Main {
    public static void main(String[] args) {
        MusicPlayerApplication musicPlayerApplication = MusicPlayerApplication.getInstance();
        musicPlayerApplication.createSong("Kesariya", "Arijit Singh");
        musicPlayerApplication.createSong("Chaiyya Chaiyya", "Sukhwinder Singh");
        musicPlayerApplication.createSong("Tum Hi Ho", "Arijit Singh");
        musicPlayerApplication.createPlayList("Bollywood Vibes");
        musicPlayerApplication.addSongToPlayList("Bollywood Vibes", "Kesariya");
        musicPlayerApplication.addSongToPlayList("Bollywood Vibes", "Chaiyya Chaiyya");
        musicPlayerApplication.addSongToPlayList("Bollywood Vibes", "Tum Hi Ho");
        musicPlayerApplication.connectAudioDevice(DeviceType.BLUETOOTH);
        musicPlayerApplication.playSingleSong("Chaiyya Chaiyya");
        musicPlayerApplication.pauseCurrentSong("Chaiyya Chaiyya");
    }
}
