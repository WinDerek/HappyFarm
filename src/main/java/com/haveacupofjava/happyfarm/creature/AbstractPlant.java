package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.produce.AbstractFruitProduce;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.util.List;

public abstract class AbstractPlant extends AbstractCreature {

    private List<AbstractFruitProduce> fruitProduce;
    /**
     * The unit is centimeter
     */
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
