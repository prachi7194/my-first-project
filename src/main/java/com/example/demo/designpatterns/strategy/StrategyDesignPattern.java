package com.example.demo.designpatterns.strategy;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }

}

interface WalkableRobot{
    public void walk();
}

class NormalWalk implements WalkableRobot{
    @Override
    public void walk() {
        System.out.println("walking normally");
    }
}

class NoWalk implements WalkableRobot{
    public void walk(){
        System.out.println("no walk");
    }
}

interface TalkableRobot{
    public void talk();
}

class NormalTalk implements TalkableRobot{

    @Override
    public void talk() {
        System.out.println("talking normally");
    }
}

class NoTalk implements TalkableRobot{

    @Override
    public void talk() {
        System.out.println("cannot talk");
    }
}

interface FlyableRobot{
    public void fly();
}

class NormalFly implements FlyableRobot{

    @Override
    public void fly() {
        System.out.println("flying normally");
    }
}

class NoFly implements FlyableRobot{

    @Override
    public void fly() {
        System.out.println("No fly");
    }
}

abstract class Robot{
    protected WalkableRobot walkableRobot;
    protected TalkableRobot talkableRobot;
    protected FlyableRobot flyableRobot;
    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkableRobot = w;
        this.talkableRobot = t;
        this.flyableRobot = f;
    }
    public void walk(){
        walkableRobot.walk();
    }
    public void talk(){
        talkableRobot.talk();
    }

    public void fly(){
        flyableRobot.fly();
    }
    public abstract void projection();
}

class CompanionRobot extends Robot{

    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("displaying companion robot features");
    }
}

class WorkerRobot extends Robot{

    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("displaying normal robot features");
    }
}

