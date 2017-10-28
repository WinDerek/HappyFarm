package com.haveacupofjava.happyfarm.room;

public class LivingRoom extends AbstractRoom {

    @Override
    public void clean() {
        if(null != cleanable){
            cleanable.clean();
        }else{
            System.out.println("there is not a clean way");
        }
    }
}
