package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
  * Class AbstractCreature
  * Abstract class of creature and observable
  * @author Yichao Wu
  */
public abstract class AbstractCreature implements Serializable{
    private List<Observer> observerList = new ArrayList<>();

    /**
     * When the farmer buy the creature, the creature's price is selling price.
     * When the farmer sell the creature, the creature's price is purchasing price.
     * Generally, the selling price is higher than the purchasing price.
     */
    private double sellingPrice;
    private double purchasingPrice;
    private String name;


    /**
      * Setters and getters
      * @author Yichao Wu
      */
    public void setSellingPrice(double price) {
        this.sellingPrice = price;
    }
    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setPurchasingPrice(double price) {
        this.purchasingPrice = price;
    }
    public double getPurchasingPrice() {
        return this.purchasingPrice;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
      * Add observer for creature
      * @param  observer
      *         the observer to be added
      * @author Yichao Wu
      */
    public synchronized void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }


    /**
      * Remove all observers from creature
      * @author Yichao Wu
      */
    public synchronized void removeAllObservers() {
        if (!observerList.isEmpty()) {
            observerList.clear();
        }
    }

    /**
      * Notify all observers
      * @param notification
      *         type of notification
      * @author Yichao Wu
      */
    void notifyAllObservers(String notification) {
        if (!observerList.isEmpty()) {
            for (Observer observer : observerList) {
                observer.update(notification);
            }
        }
    }

    /**
      * Creature produce agricultural product
      * @author Yichao Wu
      */
    public abstract void produce();
}
