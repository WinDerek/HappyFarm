package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.creature.group.PlantGroup;
import com.haveacupofjava.happyfarm.security.MethodExposedException;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractFarmland<T extends AbstractPlant> extends AbstractField {

    private static final String TAG = AbstractFarmland.class.getSimpleName();

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

        System.out.println(TAG + ": " + plant.getClass().getSimpleName()  + "@" +
                plant.hashCode() + " is added into " + getClass().getSimpleName() + "@" +
                hashCode());
    }

    /**
     * Plants all the plants in this farmland
     */
    public void waterPlants() {
        try {
            plantGroup.water();
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }

        System.out.println(TAG + ": All the plants in " + getClass().getSimpleName() + "@" +
                hashCode() + " have been watered.");
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

    @Override
    public void stimulateProduction() {
        plantGroup.produce();
    }

}
