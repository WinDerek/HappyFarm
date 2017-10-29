package com.haveacupofjava.happyfarm.creature.group;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class PlantGroup<T extends AbstractPlant> {

    private static final String TAG = PlantGroup.class.getSimpleName();

    private List<T> plants;

    public PlantGroup() {
        plants = new ArrayList<T>();
    }

    /**
     * Waters all the plants in this group
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void water() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        for (T plant : plants) {
            plant.water();
        }

        String plantClassName = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0].getTypeName();
        System.out.println(TAG + ": All the " + plantClassName + " have been watered.");
    }

    /**
     * Adds an plant into this group
     * @param plant The plant to be added
     */
    public void addPlant(T plant) {
        plants.add(plant);

        System.out.println(TAG + ": " + plant.toString() + " has been added to " + toString());
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
