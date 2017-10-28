package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public class PigPen extends AbstractPen<Pig> {

    @Override
    public void show() {
        System.out.println("pig pen shown");
    }

    @Override
    public void acceptVisitor(AbstractFieldVisitor visitor) {
        visitor.visit(this);
    }

}
