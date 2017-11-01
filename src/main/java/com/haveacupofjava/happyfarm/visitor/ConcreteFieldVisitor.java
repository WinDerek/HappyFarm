package com.haveacupofjava.happyfarm.visitor;

import com.haveacupofjava.happyfarm.field.AbstractFarmland;
import com.haveacupofjava.happyfarm.field.AbstractPen;

public class ConcreteFieldVisitor implements AbstractFieldVisitor {

    private static final String TAG = ConcreteFieldVisitor.class.getSimpleName();

    @Override
    public void visit(AbstractFarmland farmLand) {
        System.out.println(TAG + ": " + getClass().getSimpleName() + "@" + hashCode() +
                " visited " + farmLand.getClass().getSimpleName() + "@" + farmLand.hashCode() +
                ".");
    }

    @Override
    public void visit(AbstractPen pen) {
        System.out.println(TAG + ": " + getClass().getSimpleName() + "@" + hashCode() +
                " visited " + pen.getClass().getSimpleName() + "@" +  pen.hashCode() + ".");
    }

}
