package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.Hen;

public class HenFactory extends AbstractAnimalFactory {

    @Override
    AbstractCreature create() {
        Hen hen = new Hen();
        hen.setSellingPrice(10.0);
        hen.setPurchasingPrice(8.0);
        hen.setBodyLength(60.0);
        hen.setName("hen");
        return hen;
    }

}
