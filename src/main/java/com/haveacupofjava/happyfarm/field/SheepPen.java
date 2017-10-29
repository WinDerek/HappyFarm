package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Sheep;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class SheepPen extends AbstractPen<Sheep> {

    public static int SHEEP_PEN_CAPACITY = 20;

    @Override
    public void show() {
        System.out.println("sheep pen shown");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getCapacity() {
        return SHEEP_PEN_CAPACITY;
    }
}
