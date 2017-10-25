package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractGame;

/**
 * GameAdapter class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class GameAdapter extends AbstractGame {

    private static final String ANDROID_NAME = "android";
    private static final String IOS_NAME = "ios";

    private Simulator simulator;
    public GameAdapter(String device, String name){
        if(ANDROID_NAME.equals(device)){
            this.simulator = new AndroidSimulator();
        }else if(IOS_NAME.equals(device)){
            this.simulator = new IosSimulator();
        }
    }

    @Override
    public void play(String device, String name) {
        simulator.play(name);
    }
}
