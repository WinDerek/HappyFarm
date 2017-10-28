package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.PigPen;
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

    /**
     * Increases the funds by some amount
     * @param amount The amount by which the funds are increased
     * @return The amount of the funds after the increase
     */
    double moneyIn(double amount) {
        this.funds += amount;
        return this.funds;
    }

    /**
     * Decreases the funds by some amount
     * @param amount The amount by which the funds are decreased
     * @return The amount of the funds after the decrease
     */
    double moneyOut(double amount) {
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

    /**
     * Adds a field into the list of fields in this farm
     * @param field The field to be added
     */
    void addField(AbstractField field) {
        fieldList.add(field);
    }

    /**
     * Returns the total capacity of the creature in this farm
     * @param clazz The class of the creature
     * @return The total capacity of the creature in this farm
     */
    int getCreatureCapacity(Class clazz) {
        int totalCapacity = 0;

        for (AbstractField field : fieldList) {
            if (field.isCreatureMatch(clazz)) {
                totalCapacity += field.getCapacity() - field.creatureCount();
            }
        }

        return totalCapacity;
    }

}
