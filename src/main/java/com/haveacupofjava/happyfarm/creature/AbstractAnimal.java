package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

public abstract class AbstractAnimal extends AbstractCreature {

    private double bodyLength;
    private double weight;

    /**
     * Feeds this animal
     * @throws MethodExposedException if the method is exposed to the outside package
     */
    public void feed() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        System.out.println("Animal " + this.toString() + " get fed.");
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
