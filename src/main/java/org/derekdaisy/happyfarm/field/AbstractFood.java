package org.derekdaisy.happyfarm.field;

import org.derekdaisy.happyfarm.CookHelper;

/**
 * AbstractFood abstract class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public abstract class AbstractFood {
    protected CookHelper cookHelper;

    public AbstractFood(CookHelper cookHelper){
        this.cookHelper = cookHelper;
    }

    /**
     * do cook action
     */
    public abstract void cook();
}
