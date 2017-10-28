package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.Sheep;

public class SheepFactory extends AbstractAnimalFactory {

    @Override
    AbstractAnimal create() {
        Sheep sheep = new Sheep();
        sheep.setSellingPrice(10.0);
        sheep.setPurchasingPrice(8.0);
        sheep.setName("sheep");
        return sheep;
    }
}
