package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;
import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

public abstract class AbstractPen extends AbstractField {

    private AnimalGroup animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup();
    }

    @Override
    public void show() {

    }

}
