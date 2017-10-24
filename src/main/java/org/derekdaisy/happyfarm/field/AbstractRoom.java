package org.derekdaisy.happyfarm.field;

import java.util.List;

/**
 * AbstractRoom abstract class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public abstract class AbstractRoom {
    public List<String> goods;

    /**
     * show the thing in room
     */
    public abstract void show();
}
