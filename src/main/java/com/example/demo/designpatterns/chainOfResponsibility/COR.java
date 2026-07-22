package com.example.demo.designpatterns.chainOfResponsibility;

abstract class MoneyHandler{
    protected MoneyHandler nextHandler;
    public MoneyHandler(){
        this.nextHandler = null;
    }
    public void setNextHandler(MoneyHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);

}

class ThousandHandler extends MoneyHandler{
    private int  numOfNotes;
    ThousandHandler(int numOfNotes){
        this.numOfNotes = numOfNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 1000;
        if(notesNeeded > numOfNotes){
            notesNeeded = numOfNotes;
            numOfNotes = 0;
        }else{
            numOfNotes = numOfNotes - notesNeeded;
        }
        if(notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + " 1000notes");
        }
        int remainingAmount = amount - (notesNeeded*1000);
        if(remainingAmount > 0){
            if(nextHandler != null){
                nextHandler.dispense(remainingAmount);
            }else{
                System.out.println("1000 dispenser took care");
            }

        }

    }
}

class FiveHunderedHandler extends MoneyHandler{
    private int  numOfNotes;
    FiveHunderedHandler(int numOfNotes){
        this.numOfNotes = numOfNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 500;
        if(notesNeeded > numOfNotes){
            notesNeeded = numOfNotes;
            numOfNotes = 0;
        }else{
            numOfNotes = numOfNotes - notesNeeded;
        }
        if(notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + " 500notes");
        }
        int remainingAmount = amount - (notesNeeded*500);
        if(remainingAmount > 0){
            if(nextHandler != null){
                nextHandler.dispense(remainingAmount);
            }else{
                System.out.println("500 dispenser took care");
            }

        }

    }
}

class TwoHunderedHandler extends MoneyHandler{
    private int  numOfNotes;
    TwoHunderedHandler(int numOfNotes){
        this.numOfNotes = numOfNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 200;
        if(notesNeeded > numOfNotes){
            notesNeeded = numOfNotes;
            numOfNotes = 0;
        }else{
            numOfNotes = numOfNotes - notesNeeded;
        }
        if(notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + " 200notes");
        }
        int remainingAmount = amount - (notesNeeded*200);
        if(remainingAmount > 0){
            if(nextHandler != null){
                nextHandler.dispense(remainingAmount);
            }else{
                System.out.println("200 dispenser took care");
            }

        }

    }
}

class HunderedHandler extends MoneyHandler{
    private int  numOfNotes;
    HunderedHandler(int numOfNotes){
        this.numOfNotes = numOfNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 100;
        if(notesNeeded > numOfNotes){
            notesNeeded = numOfNotes;
            numOfNotes = 0;
        }else{
            numOfNotes = numOfNotes - notesNeeded;
        }
        if(notesNeeded > 0){
            System.out.println("Dispensing " + notesNeeded + "  100 notes");
        }
        int remainingAmount = amount - (notesNeeded*100);
        if(remainingAmount > 0){
            if(nextHandler != null){
                nextHandler.dispense(remainingAmount);
            }else{
                System.out.println("100 dispenser took care");
            }

        }

    }
}
public class COR {
    public static void main(String[] args) {
        MoneyHandler thousandHandler = new ThousandHandler(5);
        MoneyHandler fiveHunderedHandler = new FiveHunderedHandler(7);
        MoneyHandler twoHunderedHandler = new TwoHunderedHandler(4);
        MoneyHandler hunderedHandler = new HunderedHandler(1);
        thousandHandler.setNextHandler(fiveHunderedHandler);
        fiveHunderedHandler.setNextHandler(twoHunderedHandler);
        twoHunderedHandler.setNextHandler(hunderedHandler);

        thousandHandler.dispense(8900);


    }
}
