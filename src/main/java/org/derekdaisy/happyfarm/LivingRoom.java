package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractRoom;

/**
 * LivingRoom class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class LivingRoom extends AbstractRoom {

    public LivingRoom(){
        furnitures.add("chair");
        furnitures.add("desk");
    }
    @Override
    public void show() {
        System.out.println("this room have good here: ");
        for(String furniture : furnitures){
            System.out.println(furnitures);
        }
    }
}
