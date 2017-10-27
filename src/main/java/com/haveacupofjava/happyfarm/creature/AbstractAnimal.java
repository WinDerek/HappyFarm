package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.security.PackageChecker;

public abstract class AbstractAnimal extends AbstractCreature {

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

}
