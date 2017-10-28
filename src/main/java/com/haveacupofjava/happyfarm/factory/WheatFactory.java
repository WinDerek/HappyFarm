package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.Wheat;

public class WheatFactory extends AbstractPlantFactory {
    @Override
    AbstractCreature create() {
        Wheat wheat = new Wheat();
        wheat.setSellingPrice(1.0);
        return wheat;
    }
}
