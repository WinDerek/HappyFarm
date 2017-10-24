package org.derekdaisy.happyfarm;

/**
 * AndroidSimulator class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class AndroidSimulator implements Simulator{

    @Override
    public void play(String name) {
        System.out.println("play " + name);
    }
}
