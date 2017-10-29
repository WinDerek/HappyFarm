package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.HenEgg;
import com.haveacupofjava.happyfarm.produce.PigMilk;

/**
  * Class Hen
  * Definition for hen
  */
public class Hen extends AbstractOvipara {

    /**
      * Hen produce eggs and notify HenProduceEgg message to all observers
      * @author Yichao Wu
      */
    @Override
    public void produce() {

        for (int i = 0; i < 2; i++) {
            HenEgg egg = new HenEgg();
            eggProduce.add(egg);
        }

        System.out.println("hey, hen eggs!");
        notifyAllObservers("HenProduceEgg");
    }

}
