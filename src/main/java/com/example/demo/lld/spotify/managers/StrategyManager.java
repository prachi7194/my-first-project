package com.example.demo.lld.spotify.managers;

import lld.spotify.enums.PlayStrategyType;
import lld.spotify.strategies.CustomQueueStrategy;
import lld.spotify.strategies.IPlayStrategy;
import lld.spotify.strategies.RandomPlayStrategy;
import lld.spotify.strategies.SequentialPlayStrategy;

public class StrategyManager {
    private IPlayStrategy iPlayStrategy;
    private static StrategyManager instance;
    private StrategyManager(){
        instance = null;
    }
    public  static StrategyManager getInstance(){
        if(instance == null){
            instance = new StrategyManager();
        }
        return instance;
    }

    public IPlayStrategy getStrategy(PlayStrategyType type){
        if(type == PlayStrategyType.RANDOM){
            return new RandomPlayStrategy();
        }else if(type == PlayStrategyType.SEQUENTIAL){
            return new SequentialPlayStrategy();
        }
        return new CustomQueueStrategy();
    }

}
