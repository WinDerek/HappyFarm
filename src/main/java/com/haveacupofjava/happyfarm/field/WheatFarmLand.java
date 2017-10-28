package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class WheatFarmLand extends AbstractFarmLand<Wheat> {

    @Override
    public void show() {
        System.out.println("WheatFarmLand shown.");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

}
