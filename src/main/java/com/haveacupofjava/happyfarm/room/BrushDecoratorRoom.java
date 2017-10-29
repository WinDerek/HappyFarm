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
     * Brushes the room
     */
    private void brush(){
        System.out.println("Brush the room");
    }

    @Override
    public void clean(String action) {
        super.clean(action);
    }

}
