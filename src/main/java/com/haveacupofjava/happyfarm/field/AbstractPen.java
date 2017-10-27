package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;

public abstract class AbstractPen extends AbstractField {

    private AnimalGroup animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup();
    }

    @Override
    public void show() {

    }

}
