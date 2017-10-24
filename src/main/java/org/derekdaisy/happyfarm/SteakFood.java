package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.AbstractFood;

/**
 * SteakFood class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class SteakFood extends AbstractFood {
    public SteakFood(CookHelper cookHelper) {
        super(cookHelper);
    }

    @Override
    public void cook() {
        cookHelper.execute();
    }
}
