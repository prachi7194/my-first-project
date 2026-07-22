package com.example.demo.lld.spotify.managers;

import com.example.demo.lld.spotify.enums.PlayStrategyType;
import com.example.demo.lld.spotify.strategies.CustomQueueStrategy;
import com.example.demo.lld.spotify.strategies.IPlayStrategy;
import com.example.demo.lld.spotify.strategies.RandomPlayStrategy;
import com.example.demo.lld.spotify.strategies.SequentialPlayStrategy;

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
