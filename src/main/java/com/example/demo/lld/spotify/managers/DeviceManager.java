package com.example.demo.lld.spotify.managers;

import com.example.demo.lld.spotify.device.IAudioOutputDevice;
import com.example.demo.lld.spotify.enums.DeviceType;
import com.example.demo.lld.spotify.factories.DeviceFactory;

public class DeviceManager {
    private IAudioOutputDevice currentOutputDevice;
    private static DeviceManager instance;
    private DeviceManager(){
        instance = null;
    }
    public static DeviceManager getInstance(){
        if(instance == null){
            instance = new DeviceManager();
        }
        return instance;
    }

    public void connect(DeviceType deviceType){
       currentOutputDevice =  DeviceFactory.createDevice(deviceType);
       switch(deviceType){
           case BLUETOOTH:
               System.out.println("Connected to bluetooth");
               break;
           case WIRED:
               System.out.println("connected to wired");
               break;
           case HEADPHONES:
               System.out.println("connected to headphones");
               break;
       }
    }
    public IAudioOutputDevice getOutputDevice(){
        if(currentOutputDevice == null){
            throw new RuntimeException("no output device is connected");
        }
        return currentOutputDevice;
    }

    public boolean hasOutputDevice(){
        return currentOutputDevice!=null;
    }
}
