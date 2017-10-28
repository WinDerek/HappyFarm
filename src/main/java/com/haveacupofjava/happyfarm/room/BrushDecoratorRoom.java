package com.haveacupofjava.happyfarm.room;

public class BrushDecoratorRoom extends AbstractRoom {

    private AbstractRoom abstractRoom;

    public BrushDecoratorRoom(AbstractRoom abstractRoom){
        this.abstractRoom = abstractRoom;
    }

    @Override
    public void show() {
        super.show();
        brush();
    }

    /**
     * brush the room
     */
    private void brush(){
        System.out.println("Brush the room");
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
