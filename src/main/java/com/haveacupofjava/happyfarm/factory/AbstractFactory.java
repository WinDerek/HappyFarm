package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.trade.Tradable;

/**
  * Class AbstractFactory
  * Abstract factory of animal factory and plant factory
  */
public abstract class AbstractFactory implements Tradable {

    /**
      * Returns an instance of creature, set its properties and return it.
      * @return An instance of creature
      */
    abstract AbstractCreature create();

}
