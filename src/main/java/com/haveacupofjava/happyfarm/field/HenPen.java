package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Hen;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class HenPen extends AbstractPen<Hen> {

    private static final int HEN_PEN_CAPACITY = 20;

    @Override
    public void show() {
        System.out.println("hen pen shown");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getCapacity() {
        return HEN_PEN_CAPACITY;
    }
}
