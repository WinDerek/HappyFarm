package com.haveacupofjava.happyfarm.visitor;

import com.haveacupofjava.happyfarm.field.AbstractFarmland;
import com.haveacupofjava.happyfarm.field.AbstractPen;

public class ConcreteFieldVisitor implements AbstractFieldVisitor {

    @Override
    public void visit(AbstractFarmland farmLand) {
        System.out.println("farmland visited.");
    }

    @Override
    public void visit(AbstractPen pen) {
        System.out.println("pan visited.");
    }

}
