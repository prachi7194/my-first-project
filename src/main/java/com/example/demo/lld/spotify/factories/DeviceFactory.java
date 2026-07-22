package com.example.demo.lld.spotify.factories;

import lld.spotify.device.BluetoothSpeakerAdapter;
import lld.spotify.device.HeadphonesAdapter;
import lld.spotify.device.IAudioOutputDevice;
import lld.spotify.device.WiredAdapter;
import lld.spotify.enums.DeviceType;
import lld.spotify.external.BluetoothSpeakerAPI;
import lld.spotify.external.HeadphonesAPI;
import lld.spotify.external.WiredSpeakerAPI;

public class DeviceFactory {

    public static IAudioOutputDevice createDevice(DeviceType deviceType){
        switch (deviceType){
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesAPI());
        }
    }
}
