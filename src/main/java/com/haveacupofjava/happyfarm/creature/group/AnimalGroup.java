package com.haveacupofjava.happyfarm.creature.group;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.util.ArrayList;
import java.util.List;

public class AnimalGroup<T extends AbstractAnimal> {

    private List<T> animals;

    public AnimalGroup() {
        animals = new ArrayList<T>();
    }

    /**
     * Feeds all the animals in this group
     */
    public void feed() {
        // Checks if the caller method is allowed to call this method
        try {
            PackageChecker.checkPackage();
        } catch (Exception exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
            return;
        }

        for (T animal : animals) {
            animal.feed();
        }
    }

    /**
     * Adds an animal into this group
     * @param animal The animal to be added
     */
    public void addAnimal(T animal) {
        animals.add(animal);
    }

    /**
     * Returns the animal at the index of the animal list
     * @param index The index of the animal
     * @return The animal at the index of the animal list
     */
    public T getAnimal(int index) {
        return animals.get(index);
    }

}
