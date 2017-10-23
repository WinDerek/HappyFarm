package org.derekdaisy.happyfarm;

public class Farmer extends Person {

    private static Farmer instance;

    private Farmer() {}

    /**
     * Returns the single instance of Farmer
     * @return The single instance of Farmer
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

}
