package org.derekdaisy.happyfarm.field;

import java.util.List;

/**
 * AbstractGame abstract class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public abstract class AbstractGame {
    public List<String> games;

    /**
     * show games
     */
    public void show(){
        for(String game : games){
            System.out.println(game);
        }
    }

    /**
     * play some games
     * @param device device type
     * @param name
     */
    public abstract void play(String device, String name);
}
