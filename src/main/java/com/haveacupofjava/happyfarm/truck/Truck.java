package com.haveacupofjava.happyfarm.truck;

public class Truck implements Vehicle, Headlight, Horn {

    public Truck() {}

    /**
     * Blares the horn and brakes the vehicle to warn pedestrians when confronted with them
     */
    public void getConfrontedWithPedestrian() {
        blareHorn();
        brakeVehicle();
    }

    /**
     * Lights the headlight and starts the vehicle to start the truck at night
     */
    public void startAtNight() {
        lightHeadlight();
        startVehicle();
    }

    @Override
    public void startVehicle() {
        System.out.println("The truck started vehicle.");
    }

    @Override
    public void stopVehicle() {
        System.out.println("The truck stopped vehicle.");
    }

    @Override
    public void brakeVehicle() {
        System.out.println("The truck braked vehicle.");
    }

    @Override
    public void blareHorn() {
        System.out.println("The truck blared horn.");
    }

    @Override
    public void lightHeadlight() {
        System.out.println("The truck lighted headlight");
    }

}
