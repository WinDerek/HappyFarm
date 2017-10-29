package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.PigMilk;

import java.util.ArrayList;
import java.util.List;

/**
  * Class Pig
  * Definition for pig
  */
public class Pig extends AbstractVivipara {

    public Pig() {
        // TODO: implement an interface in HappyFarm, also in Sheep, Wheat, ...
        produce();
    }

    /**
      * Pig produce milk and notify PigProduceMilk message to the observers
      * @author Yichao Wu
      */
    @Override
    public void produce() {
        for (int i = 0; i < 10; i++) {
            PigMilk milk = new PigMilk();
            milkProduce.add(milk);
        }

        System.out.println("hey, pig milk!");
        notifyAllObservers("PigProduceMilk");
    }

}
