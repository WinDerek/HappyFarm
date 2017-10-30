package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;
import com.haveacupofjava.happyfarm.produce.AbstractEggProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.security.MethodExposedException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractPen<T extends AbstractAnimal> extends AbstractField {

    private static final String TAG = AbstractPen.class.getSimpleName();

    private AnimalGroup<T> animalGroup;

    public AbstractPen() {
        animalGroup = new AnimalGroup<>();
    }

    @Override
    public void show() {}

    /**
     * Adds an animal into the animal group of this pen
     * @param animal The animal to be added
     */
    public void addAnimal(T animal) {
        animalGroup.addAnimal(animal);

        System.out.println(TAG + ": " + animal.getClass().getSimpleName() + "@" +
                animal.hashCode() + " is added into " + getClass().getSimpleName() + "@" +
                hashCode() + ".");
    }

    /**
     * Feeds all the animals in this pen
     */
    public void feedAnimals() {
        try {
            animalGroup.feed();
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }

        System.out.println(TAG + ": All the animals in " + getClass().getSimpleName() + "@" +
                hashCode() + " have been fed.");
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

    /**
     * Returns a list of milk produces in this pen. Returns null if there are no animals in this pen
     * or the animals are oviparas
     * @return A list of milk produces in this pen. Null if the here are no animals in this pen or
     * the animals are oviparas
     */
    public List<AbstractMilkProduce> getMilkProduce() {
        return animalGroup.getMilkProduce();
    }

    /**
     * Returns a list of egg produces in this pen. Returns null if there are no animals in this pen
     * or the animals are viviparas
     * @return A list of egg produces in this pen. Null if the here are no animals in this pen or
     * the animals are viviparas
     */
    public List<AbstractEggProduce> getEggProduce() {
        return animalGroup.getEggProduce();
    }

    @Override
    public void stimulateProduction() {
        animalGroup.produce();
    }

}
