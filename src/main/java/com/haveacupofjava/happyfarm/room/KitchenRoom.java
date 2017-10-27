package com.haveacupofjava.happyfarm.room;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class KitchenRoom extends AbstractRoom {

    @Override
    public void clean() {
        if(null != cleanable){
            cleanable.clean();
        }else{
            System.out.println("you do not add clean way");
        }

    }


}
