package com.haveacupofjava.happyfarm.creature.group;

import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class PlantGroup<T extends AbstractPlant> extends AbstractPlant implements Serializable{

    private static final String TAG = PlantGroup.class.getSimpleName();

    private List<T> plants;

    public PlantGroup() {
        plants = new ArrayList<T>();
    }

    /**
     * Waters all the plants in this group
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    @Override
    public void water() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        for (T plant : plants) {
            plant.water();
        }


        // TODO: Fix: java.lang.ClassCastException: java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType
//        String plantClassName = ((ParameterizedType) getClass().getGenericSuperclass())
//                .getActualTypeArguments()[0].getTypeName();
//        System.out.println(TAG + ": All the " + plantClassName + " in " + toString() +
//                " have been watered.");
        System.out.println(TAG + ": All the plants in " + getClass().getSimpleName() + "@" +
                hashCode() + " have produces once.");
    }

    /**
     * Let all the plants to produce once
     */
    @Override
    public void produce() {
        for (T plant : plants) {
            plant.produce();
        }

        // TODO: Fix: java.lang.ClassCastException: java.lang.Class cannot be cast to java.lang.reflect.ParameterizedType
//        String plantClassName = ((ParameterizedType) getClass().getGenericSuperclass())
//                .getActualTypeArguments()[0].getTypeName();
//        System.out.println(TAG + ": All the " + plantClassName + " in " + toString() +
//                " have produced once.");
        System.out.println(TAG + ": All the plants in " + getClass().getSimpleName() + "@" +
                hashCode() + " have produces once.");
    }

    /**
     * Adds an plant into this group
     * @param plant The plant to be added
     */
    public void addPlant(T plant) {
        plants.add(plant);

        System.out.println(TAG + ": " + plant.getClass().getSimpleName() + "@" +
                plant.hashCode() + " has been added to " + getClass().getSimpleName() + "@" +
                hashCode() + ".");
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
