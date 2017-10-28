package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class WheatFarmLand extends AbstractFarmland<Wheat> {

    @Override
    public void show() {
        System.out.println("a wheat farmland");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

}
