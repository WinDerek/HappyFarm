package com.haveacupofjava.happyfarm.factory;


import com.haveacupofjava.happyfarm.creature.AbstractAnimal;

/**
  * Class AbstractAnimalFactory
  * Abstract factory of all animal factories
  * @author Yichao Wu
  */
abstract class AbstractAnimalFactory extends AbstractFactory {
    public AbstractAnimal getAnimal() {
        return (AbstractAnimal) create();
    }
}
