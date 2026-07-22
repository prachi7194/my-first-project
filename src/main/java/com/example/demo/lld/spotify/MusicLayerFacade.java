package com.example.demo.lld.spotify;

import lld.spotify.device.IAudioOutputDevice;
import lld.spotify.enums.DeviceType;
import lld.spotify.enums.PlayStrategyType;
import lld.spotify.managers.DeviceManager;
import lld.spotify.managers.PlayListManager;
import lld.spotify.managers.StrategyManager;
import lld.spotify.models.PlayList;
import lld.spotify.models.Song;
import lld.spotify.strategies.IPlayStrategy;

public class MusicLayerFacade {
    private static MusicLayerFacade instance = null;
    private PlayList loadedPlayList;
    private IPlayStrategy strategy;
    private AudioEngine audioEngine;

    public MusicLayerFacade(){
        loadedPlayList = null;
        strategy = null;
        audioEngine = new AudioEngine();
    }
    public static synchronized MusicLayerFacade getInstance(){
        if(instance == null){
            instance = new MusicLayerFacade();
        }
        return instance;
    }
    public void connectDevice(DeviceType deviceType){
        DeviceManager.getInstance().connect(deviceType);
    }

    public void setPlayStrategy(PlayStrategyType playStrategy){
        strategy = StrategyManager.getInstance().getStrategy(playStrategy);
    }

    public void loadPlayList(String name){
        loadedPlayList = PlayListManager.getInstance().getPlayList(name);
        if(loadedPlayList == null){
            throw new RuntimeException("playlist is empty");
        }
        strategy.setPlayList(loadedPlayList);

    }

    public void playSong(Song song){
        if(!DeviceManager.getInstance().hasOutputDevice()){
            throw new RuntimeException("no audio device connected");
        }
        IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
        audioEngine.play(device, song);

    }

    public void pauseSong(Song song){
        if(!audioEngine.getCurrentSongTitle().equals(song.getTitle())){
            throw new RuntimeException("Cannot pause \"" + song.getTitle() + "\"; not currently playing.");

        }
       audioEngine.pause();
    }




}
