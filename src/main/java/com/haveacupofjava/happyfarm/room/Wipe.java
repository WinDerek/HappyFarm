package com.haveacupofjava.happyfarm.room;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class Wipe implements Cleanable {

    @Override
    public void clean() {
        System.out.println("Wiped the room");
    }
}
