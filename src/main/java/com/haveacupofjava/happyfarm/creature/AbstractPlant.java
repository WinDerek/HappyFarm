package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;

import java.util.List;

/**
  * Class AbstractPlant
  * Define properties that all plants have
  * @author Yichao Wu
  */
public abstract class AbstractPlant extends AbstractCreature {

    private List<AbstractFruitProduce> fruitProduce;
    private double height;

}
