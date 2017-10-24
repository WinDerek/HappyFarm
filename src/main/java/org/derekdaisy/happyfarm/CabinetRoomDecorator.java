package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.Room;
/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class CabinetRoomDecorator extends Room {

    private Room room;
    public CabinetRoomDecorator(Room room){
        this.room = room;

    }
    @Override
    public void show() {
        room.show();
        System.out.println("cabinet");
    }
}
