package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.util.List;

public abstract class AbstractPlant extends AbstractCreature {

    private static final String TAG = AbstractPlant.class.getSimpleName();

    // TODO: Constructor new list for fruitProduce?

    private List<AbstractFruitProduce> fruitProduce;

    /**
     * The unit is centimeter
     */
    private double height;

    /**
     * Waters this plant
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void water() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        System.out.println(TAG + ": The plant " + this.toString() + " gets watered.");
    }

    public List<AbstractFruitProduce> getFruitProduce() {
        return fruitProduce;
    }

    public void setFruitProduce(List<AbstractFruitProduce> fruitProduce) {
        this.fruitProduce = fruitProduce;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
