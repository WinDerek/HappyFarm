package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;

public abstract class AbstractPen extends AbstractField {

    private AnimalGroup animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup();
    }

    @Override
    public void show() {
    }

    /**
     * Adds an animal into the animal group of this pen
     * @param animal The animal to be added
     */
    public void addAnimal(AbstractAnimal animal) {
        animalGroup.addAnimal(animal);
    }

    /**
     * Feeds all the animals in this pen
     */
    public void feedAnimals() {
        animalGroup.feed();
    }

}
