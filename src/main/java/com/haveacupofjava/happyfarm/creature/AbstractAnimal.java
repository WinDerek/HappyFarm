package com.haveacupofjava.happyfarm.creature;

/**
  * Class AbstractAnimal
  * Define properties that all animals have
  * @author Yichao Wu
  */
public abstract class AbstractAnimal extends AbstractCreature {

    private double bodyLength;
    private double weight;

    /**
     * Setters and getters
     * @author Yichao Wu
     */

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
