package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;

import java.util.List;


public abstract class AbstractPlantFactory extends AbstractFactory {
    public AbstractPlant getPlant() {
        return (AbstractPlant)create();
    }
}
