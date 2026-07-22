package com.example.demo.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber{
    public void update();
}

interface IChannel{
    public void addSubscriber(ISubscriber subscriber);
    public void removeSubscriber(ISubscriber subscriber);
    public void notifySubscribers();
}

class Channel implements IChannel{
    List<ISubscriber> iSubscriberList;
    private String name;
    private String latestVideo;
    public Channel(String name){
        this.name = name;
        this.iSubscriberList = new ArrayList<>();
    }
    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(!iSubscriberList.contains(subscriber)){
            iSubscriberList.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        iSubscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(ISubscriber iSubscriber: iSubscriberList){
            iSubscriber.update();
        }

    }

    public void uploadVideo(String title) {
        latestVideo = title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscribers();
    }

    public String getVideoData() {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;

    Subscriber(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());

    }
}


public class ObserverDesignPattern {
    public static void main(String[] args) {
        Channel channel = new Channel("coder army");
        Subscriber subscriber1 = new Subscriber("Prachi",channel);
        Subscriber subscriber2 = new Subscriber("Hello",channel);
        channel.addSubscriber(subscriber1);
        channel.addSubscriber(subscriber2);
        channel.uploadVideo("observer pattern tutorial");
        channel.removeSubscriber(subscriber2);
        channel.uploadVideo("decorator pattern");
    }
}
