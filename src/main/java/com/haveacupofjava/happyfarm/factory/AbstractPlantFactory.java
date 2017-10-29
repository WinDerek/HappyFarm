package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;

import java.util.List;

public abstract class AbstractPlantFactory extends AbstractFactory {

    /**
     * Returns a plant from this factory
     * @return A plant from this factory
     */
    public AbstractPlant getPlant() {
        return (AbstractPlant) create();
    }

}
