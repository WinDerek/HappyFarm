package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.PigMilk;

import java.util.ArrayList;
import java.util.List;

/**
  * Class Pig
  * Definition for pig
  * @author Yichao Wu
  */
public class Pig extends AbstractVivipara{

    /**
      * Pig produce milk and notify PigProduceMilk message to the observers
      * @author Yichao Wu
      */
    @Override
    public void produce() {
        List<AbstractMilkProduce> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PigMilk milk = new PigMilk();
            list.add(milk);
        }
        this.setMilkProduce(list);

        System.out.println("hey, pig milk!");
        notifyAllObservers("PigProduceMilk");
    }

}
