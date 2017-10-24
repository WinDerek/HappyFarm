package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.Game;

/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class ComputerGame extends Game {

    private GameAdapter gameAdapter;

    @Override
    public void play(String device, String name) {
        if(device.equals("computer")){
            System.out.println("play " + name);
        }else{
            gameAdapter = new GameAdapter(device, name);
            gameAdapter.play(device, name);
        }
    }
}
