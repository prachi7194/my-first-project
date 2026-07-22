package com.example.demo.lld.spotify.device;

import lld.spotify.external.BluetoothSpeakerAPI;
import lld.spotify.models.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice {
    BluetoothSpeakerAPI bluetoothSpeakerAPI;
    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI){
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + "by" + song.getArtist();
        bluetoothSpeakerAPI.playSoundViaBluetooth(payload);

    }
}
