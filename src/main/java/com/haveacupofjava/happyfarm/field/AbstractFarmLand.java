package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.creature.group.PlantGroup;

public abstract class AbstractFarmLand<T extends AbstractPlant> extends AbstractField {

    private PlantGroup<T> plantGroup;

    public AbstractFarmLand() {
        plantGroup = new PlantGroup<>();
    }

}
