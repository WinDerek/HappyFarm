package org.derekdaisy.happyfarm;

/**
 * IosSimulator class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class IosSimulator implements Simulator {
    @Override
    public void play(String name) {
        System.out.println("play " + name);
    }
}
