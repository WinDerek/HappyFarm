package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.security.PackageChecker;

public abstract class AbstractAnimal extends AbstractCreature {

    private double bodyLength;
    private double weight;

    /**
     * Feeds the animal
     */
    public void feed() {
        // Checks if the caller method is allowed to call this method
        try {
            PackageChecker.checkPackage();
        } catch (Exception exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
            return;
        }

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
