package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

public class MilkBox extends SpecialBox {


    public MilkBox(){
        setName("milkBox");
    }

    @Override
    public void store(List<AbstractProduct> products, AbstractProduce produce) {
        getProduces().add(produce);
        products.add(this);
        System.out.println("Storage " + produce.getName() + " in the " + getName());
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
