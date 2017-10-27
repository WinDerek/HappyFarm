package com.haveacupofjava.happyfarm;

public class Farmer {

    private static Farmer instance;
    private static HappyFarm happyFarm;

    private Farmer() {
        happyFarm = HappyFarm.getInstance();
    }

    /**
     * Returns a single instance of Farmer
     * @return A single instance of Farmer
     */
    public static Farmer getInstance() {
        Farmer inst = instance;
        if (inst == null) {
            synchronized (Farmer.class) {
                inst = instance;
                if (inst == null) {
                    inst = new Farmer();
                    instance = inst;
                }
            }
        }

        return inst;
    }

    private void payMoney(double amount) {
        System.out.println(Farmer.class.getName() + ".payMoney(" + amount + ") called.");
        System.out.println("Current amount of money is: " + happyFarm.getFunds() + ".");
        System.out.println("After paying, the amount of money is: " + happyFarm.moneyOut(amount));
    }

    private void gainMoney(double amount) {
        happyFarm.moneyIn(amount);
    }

    public void buyAnimal(Class clazz, int number) {

    }

    public void buyPlant(Class clazz, int number) {

    }

}
