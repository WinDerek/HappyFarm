package com.haveacupofjava.happyfarm.room;

public class BoxAdapter implements Box {

    private AdvanceBox advanceBox;

    public BoxAdapter(String name){
        if(name.equals("meat")){
            advanceBox = new MeatBox();
        }else if(name.equals("egg")){
            advanceBox = new EggBox();
        }
    }

    @Override
    public void storage(String name) {
        if(name.equals("meat")){
            advanceBox.storage();
        }else if(name.equals("egg")){
            advanceBox.storage();
        }
    }
}
