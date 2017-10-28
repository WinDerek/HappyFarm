package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.visitor.ConcreteFieldVisitor;

import java.util.ArrayList;
import java.util.List;

public class HappyFarm {

    private static HappyFarm instance;

    private Double funds;

    private List<AbstractField> fieldList;

    private static final double INITIAL_FUNDS = 1000.0;

    private HappyFarm() {
        funds = INITIAL_FUNDS;
        fieldList = new ArrayList<AbstractField>();
    }

    /**
     * Returns a single instance of HappyFarm
     * @return A single instance of HappyFarm
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

    protected double moneyIn(double amount) {
        this.funds += amount;
        return this.funds;
    }

    protected double moneyOut(double amount) {
        this.funds -= amount;
        return this.funds;
    }

    public double getFunds() {
        return this.funds;
    }

    /**
     * Shows the information of the field in this farm
     */
    public void showFieldsInformation() {
        ConcreteFieldVisitor visitor = new ConcreteFieldVisitor();
        for (AbstractField field : fieldList) {
            field.acceptVisitor(visitor);
        }
    }

}
