package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractRoom;

/**
 * BedRoom class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class BedRoom extends AbstractRoom {

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
