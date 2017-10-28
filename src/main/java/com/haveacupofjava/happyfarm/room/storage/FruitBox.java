package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

public class FruitBox extends SpecialBox {

    public FruitBox(){
        setName("fruitBox");
    }
    @Override
    public void storage(List<AbstractProduct> products, AbstractProduce produce) {
        getProduces().add(produce);
        products.add(this);
        System.out.println("Storage fruit in the " + getName());
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
