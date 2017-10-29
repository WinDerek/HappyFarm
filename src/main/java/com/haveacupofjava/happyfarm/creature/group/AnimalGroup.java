package com.haveacupofjava.happyfarm.creature.group;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractOvipara;
import com.haveacupofjava.happyfarm.creature.AbstractVivipara;
import com.haveacupofjava.happyfarm.produce.AbstractEggProduce;
import com.haveacupofjava.happyfarm.produce.AbstractMilkProduce;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AnimalGroup<T extends AbstractAnimal> {

    private static final String TAG = AnimalGroup.class.getSimpleName();

    private List<T> animals;

    public AnimalGroup() {
        animals = new ArrayList<T>();
    }

    /**
     * Feed all the animals in this group
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void feed() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        for (T animal : animals) {
            animal.feed();
        }

        String animalClassName = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0].getTypeName();
        System.out.println(TAG + ": All the " + animalClassName + " have been fed.");
    }

    /**
     * Adds an animal into this group
     * @param animal The animal to be added
     */
    public void addAnimal(T animal) {
        animals.add(animal);

        System.out.println(TAG + ": " + animal.toString() + " has been added to " + toString());
    }

    /**
     * Returns the animal at the index of the animal list
     * @param index The index of the animal
     * @return The animal at the index of the animal list
     */
    public T getAnimal(int index) {
        return animals.get(index);
    }

    /**
     * Returns the number of the animals in this group
     * @return The number of the animals in this group
     */
    public int animalCount() {
        return animals.size();
    }

    /**
     * Returns a list of all the milk produces in this animal group. Returns null if the animal
     * list is null or the animals are oviparas.
     * @return A list of all the milk produces in this animal group. Null if the animal list is
     * null or the animals are oviparas.
     */
    public List<AbstractMilkProduce> getMilkProduce() {
        // If the animal list is null
        if (animals == null) {
            return null;
        }

        // If the animal is AbstractOvipara
        if (animals.get(0) instanceof AbstractOvipara) {
            return null;
        }

        List<AbstractMilkProduce> list = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            list.addAll(((AbstractVivipara) animal).getMilkProduce());
        }
        return list;
    }

    /**
     * Returns a list of all the egg produces in this animal group. Returns null if the animal
     * list is null or the animals are viviparas
     * @return A list of all the egg produces in this animal group. Null if the animal list is null
     * or the animals are viviparas
     */
    public List<AbstractEggProduce> getEggProduce() {
        // If the animal list is null
        if (animals == null) {
            return null;
        }

        // If the animal is AbstractVivipara
        if (animals.get(0) instanceof AbstractVivipara) {
            return null;
        }

        List<AbstractEggProduce> list = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            list.addAll(((AbstractOvipara) animal).getEggProduce());
        }
        return list;
    }

}
