package com.haveacupofjava.happyfarm.room;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Mop implements Cleanable {

    @Override
    public void clean() {
        System.out.println("Mopped the room");
    }

}
