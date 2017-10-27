package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;

/**
  * Class AbstractFactory
  * Abstract factory of animal factory and plant factory
  * @author Yichao Wu
  */
abstract class AbstractFactory {
    /**
      * Generate an instance of creature, set its properties and return it.
      * @return an instance of creature
      * @author Yichao Wu
      */
    abstract AbstractCreature create();
}
