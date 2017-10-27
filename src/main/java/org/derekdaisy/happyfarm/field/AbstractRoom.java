package org.derekdaisy.happyfarm.field;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * AbstractRoom abstract class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public abstract class AbstractRoom {
    public List<String> furnitures;
    public Queue<String> queue;

    /**
     * show the thing in room
     */
    public abstract void show();
}
