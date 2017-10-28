package com.haveacupofjava.happyfarm.creature.group;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.util.ArrayList;
import java.util.List;

public class PlantGroup <T extends AbstractPlant> {

    private List<T> plants;

    public PlantGroup() {
        plants = new ArrayList<T>();
    }

    /**
     * Waters all the plants in this group
     */
    public void water() {
        // Checks if the caller method is allowed to call this method
        try {
            PackageChecker.checkPackage();
        } catch (Exception exception) {
            System.out.println(exception.toString());
            exception.printStackTrace();
            return;
        }

        for (T plant : plants) {
            plant.water();
        }
    }

    /**
     * Adds an plant into this group
     * @param plant The plant to be added
     */
    public void addPlant(T plant) {
        plants.add(plant);
    }

    /**
     * Returns the plant at the index of the plant list
     * @param index The index of the plant
     * @return The plant at the index of the plant list
     */
    public T getPlant(int index) {
        return plants.get(index);
    }

    /**
     * Returns the number of the plants in this farmland
     * @return The number of the plants in this farmland
     */
    public int plantCount() {
        return plants.size();
    }

}
