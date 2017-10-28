package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.creature.group.PlantGroup;

public abstract class AbstractFarmland extends AbstractField {

    private PlantGroup plantGroup;

    public AbstractFarmland() {
        plantGroup = new PlantGroup();
    }

    @Override
    public void show() {}

    /**
     * Adds a plant into the plant group of this farmland
     * @param plant The plant to be added
     */
    public void addPlant(AbstractPlant plant) {
        plantGroup.addPlant(plant);
    }

    /**
     * Plants all the plants in this farmland
     */
    public void waterPlants() {
        plantGroup.water();
    }

}
