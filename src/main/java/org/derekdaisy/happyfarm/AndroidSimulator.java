package org.derekdaisy.happyfarm;

/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class AndroidSimulator implements Simulator{

    @Override
    public void play(String name) {
        System.out.println("play " + name);
    }
}
