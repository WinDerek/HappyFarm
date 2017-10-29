package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class PigPen extends AbstractPen<Pig> {

    private static final int PIG_PEN_CAPACITY = 20;

    @Override
    public void show() {
        System.out.println(toString() + " shown.");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getCapacity() {
        return PIG_PEN_CAPACITY;
    }

}
