package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class NormalBox extends AbstractBox {

    private BoxAdapter boxAdapter;

    public NormalBox(){
        setName("normalBox");
    }


    /**
     * Override store
     * @param products products list
     * @param produce the produce will be stored
     */
    @Override
    public void store(List<AbstractProduct> products, AbstractProduce produce) {
        String name = produce.getName();
        // store special produce
        if(name.endsWith("meat") || name.endsWith("milk") || name.endsWith("fruit")){
            boxAdapter = new BoxAdapter(produce);
            boxAdapter.store(products, produce);
            //getProducts().add(boxAdapter);
        }else{
            getProduces().add(produce);
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
