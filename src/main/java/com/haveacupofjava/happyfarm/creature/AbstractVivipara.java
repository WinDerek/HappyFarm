package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;

import java.util.ArrayList;
import java.util.List;

/**
  * Class AbstractVivipara
  * Define property that all Vivipara have
  */
public abstract class AbstractVivipara extends AbstractAnimal {

    private static final String TAG = AbstractVivipara.class.getSimpleName();

    protected List<AbstractMilkProduce> milkProduce = new ArrayList<>();

    public List<AbstractMilkProduce> getMilkProduce() {
        return milkProduce;
    }

}
