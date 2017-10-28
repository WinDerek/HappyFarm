package com.haveacupofjava.happyfarm.trade;

public class Market implements Tradable {

    private static Market instance;

    /**
     * Returns a single instance of Market
     * @return A single instance of Market
     */
    public static Market getInstance() {
        Market inst = instance;
        if (inst == null) {
            synchronized (Market.class) {
                inst = instance;
                if (inst == null) {
                    inst = new Market();
                    instance = inst;
                }
            }
        }

        return inst;
    }

}
