package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractRoom;

/**
 * CabinetRoomDecorator class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class CabinetRoomDecorator extends AbstractRoom {

    private AbstractRoom room;

    public CabinetRoomDecorator(AbstractRoom room){
        this.room = room;

    }
    @Override
    public void show() {
        room.show();
        System.out.println("cabinet");
    }
}
