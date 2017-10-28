package com.haveacupofjava.happyfarm.factory;


import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.Pig;

public class PigFactory extends AbstractAnimalFactory {

    @Override
    AbstractCreature create() {
        Pig pig = new Pig();
        pig.setSellingPrice(10.0);
        return pig;
    }
}
