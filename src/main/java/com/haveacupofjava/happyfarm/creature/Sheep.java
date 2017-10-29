package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.SheepMilk;

import java.util.ArrayList;
import java.util.List;

/**
  * Class Sheep
  * Definition for sheep
  */
public class Sheep extends AbstractVivipara {

    /**
      * Sheep produce milk and notify SheepProduceMilk message to the observers
      */
    @Override
    public void produce() {
        for (int i = 0; i < 10; i++) {
            SheepMilk milk = new SheepMilk();
            milkProduce.add(milk);
        }

        System.out.println("hey, sheep milk!");
        notifyAllObservers("SheepProduceMilk");
    }

}
