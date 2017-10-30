package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.field.AbstractPen;

import java.util.List;

public abstract class AbstractPlantFactory extends AbstractFactory {

    /**
     * Returns a plant from this factory
     * @return A plant from this factory
     */
    public AbstractPlant getPlant() {
        AbstractPlant plant = (AbstractPlant) create();
        plant.addObserver(Farmer.getInstance());
        return plant;
    }

}
