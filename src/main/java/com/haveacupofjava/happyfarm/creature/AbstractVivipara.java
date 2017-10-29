package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;

import java.util.List;

/**
  * Class AbstractVivipara
  * Define property that all Vivipara have
  */
public abstract class AbstractVivipara extends AbstractAnimal {

    private static final String TAG = AbstractVivipara.class.getSimpleName();

    // TODO: Constructor new list for milkProduce?

    private List<AbstractMilkProduce> milkProduce;

    public List<AbstractMilkProduce> getMilkProduce() {
        return milkProduce;
    }

    void setMilkProduce(List<AbstractMilkProduce> milkProduce) {
        this.milkProduce = milkProduce;
    }

}
