package com.example.demo.lld.spotify.strategies;

import lld.spotify.models.PlayList;
import lld.spotify.models.Song;

public interface IPlayStrategy {
    void setPlayList(PlayList playList);
    Song next();
    Song previous();
    boolean hasNext();
    boolean hasPrevious();
    default void addToNext(Song song){};
}
