package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractEggProduce;

import java.util.List;

/**
  * Class AbstractOvipara
  * Define property that all Ovipara have
  */
public abstract class AbstractOvipara extends AbstractAnimal {

    private List<AbstractEggProduce> eggProduce;

    // TODO: Constructor new list for eggProduce?

    /**
     * Returns a list of all the egg produces of this {@code AbstractOvipara}
     * @return A list of all the egg produces of this {@code AbstractOvipara}
     */
    public List<AbstractEggProduce> getEggProduce() {
        return eggProduce;
    }

    public void setEggProduce(List<AbstractEggProduce> eggProduce) {
        this.eggProduce = eggProduce;
    }

}
