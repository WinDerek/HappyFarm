package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractPen<T extends AbstractAnimal> extends AbstractField {

    private AnimalGroup<T> animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup<>();
    }

    @Override
    public void show() {
    }

    /**
     * Adds an animal into the animal group of this pen
     * @param animal The animal to be added
     */
    public void addAnimal(T animal) {
        animalGroup.addAnimal(animal);
    }

    /**
     * Feeds all the animals in this pen
     */
    public void feedAnimals() {
        animalGroup.feed();
    }

    @Override
    public boolean isCreatureMatch(Class clazz) {
        return clazz.getName()
                .equals(
                        ((ParameterizedType) getClass().getGenericSuperclass())
                                .getActualTypeArguments()[0].getTypeName()
                );
    }

    @Override
    public int creatureCount() {
        return animalGroup.animalCount();
    }

}
