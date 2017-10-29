package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMeatProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

public class BoxAdapter extends AbstractBox {

    private SpecialBox specialBox;

    public BoxAdapter(AbstractProduce produce) {
        if (produce instanceof AbstractMeatProduce) {
            specialBox = new MeatBox();
        } else if (produce instanceof AbstractMilkProduce) {
            specialBox = new MilkBox();
        } else if (produce instanceof AbstractFruitProduce) {
            specialBox = new FruitBox();
        }
    }

    @Override
    public void store(List<AbstractProduct> products, AbstractProduce produce) {
        if (produce instanceof AbstractMeatProduce) {
            specialBox.store(products, produce);
        } else if (produce instanceof AbstractMilkProduce) {
            specialBox.store(products, produce);
        } else if (produce instanceof AbstractFruitProduce) {
            specialBox.store(products, produce);
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
