package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class BoxAdapter extends Box {

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
            default:
                break;
        }
    }

    @Override
    public void storage(AbstractProduce produce) {
        String name = produce.getName();
        if(name.equals("meat")){
            specialBox.storage(produce);
        }else if(name.equals("milk")){
            specialBox.storage(produce);
        }else if(name.equals("fruit")){
            specialBox.storage(produce);
        }
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }
}
