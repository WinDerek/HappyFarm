package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

public abstract class AbstractAnimal extends AbstractCreature {

    private static final String TAG = AbstractAnimal.class.getSimpleName();

    /**
     * The unit is centimeter
     */
    private double bodyLength;
    /**
     * The unit is kilogram
     */
    private double weight;

    /**
     * Feeds this animal
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void feed() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        System.out.println(TAG + ": The animal " + this.toString() + " gets fed.");
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
