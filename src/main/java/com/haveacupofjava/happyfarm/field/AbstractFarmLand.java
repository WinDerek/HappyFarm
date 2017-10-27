package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.group.PlantGroup;

public abstract class AbstractFarmLand extends AbstractField {

    private PlantGroup plantGroup;

    public AbstractFarmLand() {
        plantGroup = new PlantGroup();
    }

}
