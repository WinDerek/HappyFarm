package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMeatProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

public class NormalBox extends AbstractBox {

    private BoxAdapter boxAdapter;

    public NormalBox(){
        setName("normalBox");
    }

    @Override
    public void store(List<AbstractProduct> products, AbstractProduce produce) {
        // store special produce
        if (produce instanceof AbstractMilkProduce ||
                produce instanceof AbstractFruitProduce ||
                produce instanceof AbstractMeatProduce) {
            boxAdapter = new BoxAdapter(produce);
            boxAdapter.store(products, produce);
        } else {
            getProduces().add(produce);
            products.add(this);
            System.out.println("Storage " + produce.getName() + " in the " + getName());
        }
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
