package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;

public abstract class AbstractPen<T extends AbstractAnimal> extends AbstractField {

    private AnimalGroup<T> animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup<>();
    }

    @Override
    public void show() {

    }

}
