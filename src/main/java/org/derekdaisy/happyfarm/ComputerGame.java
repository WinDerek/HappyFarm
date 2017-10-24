package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractGame;

/**
 * ComputerGame class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class ComputerGame extends AbstractGame {

    private GameAdapter gameAdapter;
    private static final String COMPUTER_NAME = "computer";

    @Override
    public void play(String device, String name) {
        if(COMPUTER_NAME.equals(device)){
            System.out.println("play " + name);
        }else{
            gameAdapter = new GameAdapter(device, name);
            gameAdapter.play(device, name);
        }
    }
}
