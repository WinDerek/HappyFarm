package com.haveacupofjava.happyfarm.creature;

import com.haveacupofjava.happyfarm.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
  * Class AbstractCreature
  * Abstract class of creature and observable
  */
public abstract class AbstractCreature implements Serializable {

    private static final String TAG = AbstractCreature.class.getSimpleName();

    private List<Observer> observerList = new ArrayList<>();

    /**
     * When the farmer buys the creature, the creature's price is selling price.
     * When the farmer sells the creature, the creature's price is purchasing price.
     * Generally, the selling price is higher than the purchasing price.
     */
    private double sellingPrice;
    private double purchasingPrice;

    private String name;

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
      * Adds observer for creature
      * @param  observer
      *         The observer to be added
      */
    public synchronized void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!observerList.contains(observer)) {
            observerList.add(observer);

            System.out.println(TAG + ": " + observer.toString() + " is added for " + toString());
        }
    }

    /**
      * Removes all observers from creature
      */
    public synchronized void removeAllObservers() {
        if (!observerList.isEmpty()) {
            observerList.clear();

            System.out.println(TAG + ": All the observers form " + toString() + " removed.");
        } else {
            System.out.println(TAG + ": No observers observing "+ toString() +
                    ", so no observers removed.");
        }
    }

    /**
      * Notifies all the observers
      * @param notification
      *         Type of notification
      */
    void notifyAllObservers(String notification) {
        if (!observerList.isEmpty()) {
            for (Observer observer : observerList) {
                observer.update(notification);
            }
        }
    }

    /**
      * Creates produce agricultural product
      */
    public abstract void produce();

}
