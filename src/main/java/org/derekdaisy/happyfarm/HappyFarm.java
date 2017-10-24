package org.derekdaisy.happyfarm;

public class HappyFarm {

    private static HappyFarm instance;

    private static double funds;

    private static final double INITIAL_FUNDS = 1000.0;

    private HappyFarm() {
        funds = INITIAL_FUNDS;
    }

    /**
     * Returns the single instance of HappyFarm
     * @return The single instance of HappyFarm
     */
    public static HappyFarm getInstance() {
        HappyFarm inst = instance;
        if (inst == null) {
            synchronized (HappyFarm.class) {
                inst = instance;
                if (inst == null) {
                    inst = new HappyFarm();
                    instance = inst;
                }
            }
        }

        return inst;
    }

}
