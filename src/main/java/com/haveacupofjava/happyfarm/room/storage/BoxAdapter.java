package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class BoxAdapter extends AbstractBox {

    private SpecialBox specialBox;

    public BoxAdapter(AbstractProduce produce){
        String name = produce.getName();
        switch (name) {
            case "meat":
                specialBox = new MeatBox();
                break;
            case "milk":
                specialBox = new MilkBox();
                break;
            case "fruit":
                specialBox = new FruitBox();
                break;
        }
    }

    @Override
    public void storage(AbstractProduce produce) {
        String name = produce.getName();
        switch (name) {
            case "meat":
                specialBox.storage(produce);
                break;
            case "milk":
                specialBox.storage(produce);
                break;
            case "fruit":
                specialBox.storage(produce);
                break;
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
