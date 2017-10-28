package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.creature.group.PlantGroup;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractFarmland<T extends AbstractPlant> extends AbstractField {

    private PlantGroup<T> plantGroup;

    public AbstractFarmland() {
        plantGroup = new PlantGroup<>();
    }

    @Override
    public void show() {}

    /**
     * Adds a plant into the plant group of this farmland
     * @param plant The plant to be added
     */
    public void addPlant(T plant) {
        plantGroup.addPlant(plant);
    }

    /**
     * Plants all the plants in this farmland
     */
    public void waterPlants() {
        plantGroup.water();
    }

    @Override
    public boolean isCreatureMatch(Class clazz) {
        return clazz.getName()
                .equals(
                        ((ParameterizedType) getClass().getGenericSuperclass())
                                .getActualTypeArguments()[0].getTypeName()
                );
    }

    @Override
    public int creatureCount() {
        return plantGroup.plantCount();
    }

}
