package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class WheatFarmland extends AbstractFarmland<Wheat> {

    private static final int WHEAT_FARMLAND_CAPACITY = 100;

    @Override
    public void show() {
        System.out.println("a wheat farmland");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getCapacity() {
        return WHEAT_FARMLAND_CAPACITY;
    }

}
