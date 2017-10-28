package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class FruitBox extends SpecialBox {

    public FruitBox(){
        setName("fruitBox");
    }
    @Override
    public void storage(AbstractProduce produce) {
        getProduces().add(produce);
        System.out.println("storage fruit in the box");
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
