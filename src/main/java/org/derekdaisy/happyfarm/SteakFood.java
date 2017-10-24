package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.field.Food;

public class SteakFood extends Food {
    public SteakFood(CookHelper cookHelper) {
        super(cookHelper);
    }

    @Override
    public void cook() {
        cookHelper.execute();
    }
}
