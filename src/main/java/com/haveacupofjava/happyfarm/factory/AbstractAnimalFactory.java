package com.haveacupofjava.happyfarm.factory;


import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.creature.AbstractAnimal;

/**
  * Class AbstractAnimalFactory
  * Abstract factory of all animal factories
  */
public abstract class AbstractAnimalFactory extends AbstractFactory {

    /**
     * Returns an animal from this factory
     * @return An animal from this factory
     */
    public AbstractAnimal getAnimal() {
        AbstractAnimal animal = (AbstractAnimal) create();
        animal.addObserver(Farmer.getInstance());
        return animal;
    }

}
