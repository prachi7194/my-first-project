package com.example.demo.lld.spotify.factories;

import com.example.demo.lld.spotify.device.BluetoothSpeakerAdapter;
import com.example.demo.lld.spotify.device.HeadphonesAdapter;
import com.example.demo.lld.spotify.device.IAudioOutputDevice;
import com.example.demo.lld.spotify.device.WiredAdapter;
import com.example.demo.lld.spotify.enums.DeviceType;
import com.example.demo.lld.spotify.external.BluetoothSpeakerAPI;
import com.example.demo.lld.spotify.external.HeadphonesAPI;
import com.example.demo.lld.spotify.external.WiredSpeakerAPI;

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
