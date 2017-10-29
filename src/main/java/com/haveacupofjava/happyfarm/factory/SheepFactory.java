package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.Sheep;

public class SheepFactory extends AbstractAnimalFactory {

    @Override
    AbstractAnimal create() {
        Sheep sheep = new Sheep();
        sheep.setSellingPrice(100.0);
        sheep.setPurchasingPrice(80.0);
        sheep.setName("sheep");
        sheep.setBodyLength(150.0);
        sheep.setWeight(80);
        return sheep;
    }

}
