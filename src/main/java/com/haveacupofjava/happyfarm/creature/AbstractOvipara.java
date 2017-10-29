package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractEggProduce;

import java.util.ArrayList;
import java.util.List;

/**
  * Class AbstractOvipara
  * Define property that all Ovipara have
  */
public abstract class AbstractOvipara extends AbstractAnimal {

    protected List<AbstractEggProduce> eggProduce = new ArrayList<>();

    /**
     * Returns a list of all the egg produces of this {@code AbstractOvipara}
     * @return A list of all the egg produces of this {@code AbstractOvipara}
     */
    public List<AbstractEggProduce> getEggProduce() {
        return eggProduce;
    }


}
