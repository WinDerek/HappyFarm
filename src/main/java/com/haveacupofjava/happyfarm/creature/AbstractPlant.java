package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.util.List;

public abstract class AbstractPlant extends AbstractCreature {

    private List<AbstractFruitProduce> fruitProduce;
    private double height;

    /**
     * Waters the plant
     */
    public void water() {
        // Checks if the caller method is allowed to call this method
        try {
            PackageChecker.checkPackage();
        } catch (Exception exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
            return;
        }

        System.out.println("Plant " + this.toString() + " get watered.");
    }

}
