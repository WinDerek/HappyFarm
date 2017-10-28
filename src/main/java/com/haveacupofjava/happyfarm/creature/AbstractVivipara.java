package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;

import java.util.List;

/**
  * Class AbstractVivipara
  * Define property that all Vivipara have
  * @author Yichao Wu
  */
public abstract class AbstractVivipara extends AbstractAnimal {

    private List<AbstractMilkProduce> milkProduce;

    public List<AbstractMilkProduce> getMilkProduce() {
        return milkProduce;
    }

    void setMilkProduce(List<AbstractMilkProduce> milkProduce) {
        this.milkProduce = milkProduce;
    }

}
