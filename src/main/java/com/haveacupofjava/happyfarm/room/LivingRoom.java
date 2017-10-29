package com.haveacupofjava.happyfarm.room;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class LivingRoom extends AbstractRoom {

    public LivingRoom() {
        setName("livingRoom");
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
