package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.SheepMilk;

import java.util.ArrayList;
import java.util.List;

/**
  * Class Sheep
  * Definition for sheep
  * @author Yichao Wu
  */
public class Sheep extends AbstractVivipara {

    private String name;

    @Override
    public void produce() {
        List<AbstractMilkProduce> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SheepMilk milk = new SheepMilk();
            list.add(milk);
        }
        this.setMilkProduce(list);
        notifyAllObservers("SheepProduceMilk");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
