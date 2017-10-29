package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.produce.Rice;

import java.util.ArrayList;
import java.util.List;

/**
  * Class Wheat
  * Definition for wheat
  */
public class Wheat extends AbstractPlant {

    /**
      * Wheat produce rice and notify WheatProduceRice message to all observers
      */
    @Override
    public void produce() {
        List<AbstractFruitProduce> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Rice fruit = new Rice();
            list.add(fruit);
        }
        this.setFruitProduce(list);

        System.out.println("hey, rice!");
        notifyAllObservers("WheatProduceFruit");
    }

}
