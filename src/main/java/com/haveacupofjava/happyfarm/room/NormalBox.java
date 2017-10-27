package com.haveacupofjava.happyfarm.room;

public class NormalBox implements Box {

    private BoxAdapter boxAdapter;


    @Override
    public void storage(String name) {
        if(name.equals("meat") || name.equals("egg")){
            boxAdapter = new BoxAdapter(name);
            boxAdapter.storage(name);
        }else{
            System.out.println("storage product in the box");
        }
    }
}
