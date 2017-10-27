package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractEggProduce;

import java.util.List;

/**
  * Class AbstractOvipara
  * Define property that all Ovipara have
  * @author Yichao Wu
  */
public abstract class AbstractOvipara extends AbstractAnimal {
    private List<AbstractEggProduce> eggProduce;

    public List<AbstractEggProduce> getEggProduce() {
        return eggProduce;
    }

    public void setEggProduce(List<AbstractEggProduce> eggProduce) {
        this.eggProduce = eggProduce;
    }
}
