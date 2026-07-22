package com.example.demo.designpatterns.command;

interface ICommand{
    void execute();
    void undo();
}

class LightCommand implements ICommand{
    Light light;
    LightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();

    }

    @Override
    public void undo() {
        light.off();

    }
}

class Light{
    public void on(){
        System.out.println("light is on");

    }
    public void off(){
        System.out.println("light is off");

    }
}

class FanCommand implements ICommand{
    Fan fan;
    FanCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();

    }

    @Override
    public void undo() {
        fan.off();

    }
}

class Fan{
    public void on(){
        System.out.println("fan is on");

    }
    public void off(){
        System.out.println("fan is off");

    }
}

class RemoteController{
    public static final int numButtons = 4;
    ICommand[] buttons;
    boolean[] buttonPressed;
    RemoteController(){
        buttons = new ICommand[numButtons];
        buttonPressed = new boolean[numButtons];
        for(int i = 0; i < numButtons;i++){
            buttons[i] = null;
            buttonPressed[i] = false;
        }
    }

    public void setCommand(int index, ICommand command){
        if(index >= 0 && index < numButtons){
            buttons[index] = command;
            buttonPressed[index] = false;

        }
    }

    public void pressButton(int idx){
        if(idx >= 0 && idx < numButtons && buttons[idx] != null){
            if(!buttonPressed[idx]){
                ICommand command = buttons[idx];
                command.execute();

            }else{
                buttons[idx].undo();
            }
            buttonPressed[idx] = !buttonPressed[idx];

        }else{
            System.out.println("No command assigned at button " + idx);
        }
    }
}



public class CommandDesignPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, new LightCommand(light));
        remoteController.setCommand(1, new FanCommand(fan));
        System.out.println("--- Toggling Light Button 0 ---");
        remoteController.pressButton(0);
        remoteController.pressButton(0);
        System.out.println("--- Toggling Fan Button 1 ---");
        remoteController.pressButton(1);  // ON
        remoteController.pressButton(1);

        // Press unassigned button to show default message
        System.out.println("--- Pressing Unassigned Button 2 ---");
        remoteController.pressButton(2);// OFF
    }
}
