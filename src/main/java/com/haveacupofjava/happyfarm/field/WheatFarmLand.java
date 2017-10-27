package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class WheatFarmLand extends AbstractFarmLand {

    @Override
    public void show() {
        System.out.println("WheatFarmLand shown.");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

}
