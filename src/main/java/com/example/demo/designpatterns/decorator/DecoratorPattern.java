package com.example.demo.designpatterns.decorator;

interface Character{
    String getAbilities();
}

class Mario implements Character{

    @Override
    public String getAbilities() {
        return "Mario";
    }
}

abstract class CharacterDecorator implements Character{
    protected Character character;
    public CharacterDecorator(Character c){
        this.character = c;
    }

}

class GunPowerUp extends CharacterDecorator{

    public GunPowerUp(Character c){
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with gun";
    }
}

class StarPowerUp extends CharacterDecorator{

    public StarPowerUp(Character c){
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + "with star power";
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
