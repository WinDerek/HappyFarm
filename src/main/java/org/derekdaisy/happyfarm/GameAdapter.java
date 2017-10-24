package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.Game;

/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class GameAdapter extends Game {

    private Simulator simulator;
    public GameAdapter(String device, String name){
        if(device.equals("android")){
            this.simulator = new AndroidSimulator();
        }else if(device.equals("ios")){
            this.simulator = new IosSimulator();
        }
    }

    @Override
    public void play(String device, String name) {
        simulator.play(name);
    }
}
