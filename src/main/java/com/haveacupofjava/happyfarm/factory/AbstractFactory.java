package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.trade.Tradable;

/**
  * Class AbstractFactory
  * Abstract factory of animal factory and plant factory
  * @author Yichao Wu
  */
public abstract class AbstractFactory implements Tradable {
    /**
      * Generate an instance of creature, set its properties and return it.
      * @return an instance of creature
      * @author Yichao Wu
      */
    abstract AbstractCreature create();
}
