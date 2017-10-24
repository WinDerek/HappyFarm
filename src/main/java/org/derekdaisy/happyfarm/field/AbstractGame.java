package org.derekdaisy.happyfarm.field;

/**
 * AbstractGame abstract class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public abstract class AbstractGame {
    public String name;

    /**
     * play some games
     * @param device device type
     * @param name
     */
    public abstract void play(String device, String name);
}
