package com.haveacupofjava.happyfarm.room;

public class Wipe implements Cleanable {
    @Override
    public void clean() {
        System.out.println("wipe the room");
    }
}
