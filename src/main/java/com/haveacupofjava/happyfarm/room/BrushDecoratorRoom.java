package com.haveacupofjava.happyfarm.room;

public class BrushDecoratorRoom extends AbstractRoom {

    private AbstractRoom abstractRoom;

    public BrushDecoratorRoom(AbstractRoom abstractRoom){
        this.abstractRoom = abstractRoom;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("brush the room");
    }

    @Override
    public void clean() {
        if(null != cleanable){
            cleanable.clean();
        }else{
            System.out.println("you do not add clean way");
        }
    }
}
