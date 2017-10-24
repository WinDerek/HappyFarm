package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.Room;

/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class BedRoom extends Room {

    public BedRoom(){
        goods.add("bed");
        goods.add("mirror");
    }

    @Override
    public void show() {
        System.out.println("this room have good here: ");
        for(String str : goods){
            System.out.println(str);
        }
    }
}
