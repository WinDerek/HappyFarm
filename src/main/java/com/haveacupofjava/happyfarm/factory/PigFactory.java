package com.haveacupofjava.happyfarm.factory;


import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.Pig;

public class PigFactory extends AbstractAnimalFactory {

    @Override
    AbstractCreature create() {
        Pig pig = new Pig();
        pig.setSellingPrice(80.0);
        pig.setPurchasingPrice(60.0);
        pig.setName("pig");
        pig.setBodyLength(120);
        pig.setWeight(400);
        return pig;
    }

}
