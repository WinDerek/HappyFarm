package com.haveacupofjava.happyfarm.room;

public class KitchenRoom extends AbstractRoom {


    public KitchenRoom() {
        setName("kitchenRoom");
    }

    @Override
    public void clean() {
        if(null != cleanable){
            cleanable.clean();
        }else{
            System.out.println("there is not a clean way");
        }
    }
}
