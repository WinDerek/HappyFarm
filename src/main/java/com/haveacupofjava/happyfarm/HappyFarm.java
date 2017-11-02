package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.field.AbstractFarmland;
import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.AbstractPen;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.room.*;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;
import com.haveacupofjava.happyfarm.visitor.ConcreteFieldVisitor;

import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class HappyFarm {

    private static HappyFarm instance;

    private Double funds = 0.0;

    private List<AbstractField> fieldList = new ArrayList<>();

    private List<AbstractRoom> roomList = new ArrayList<>();

    private static final double INITIAL_FUNDS = 1000.0;

    private HappyFarm() {
        funds = INITIAL_FUNDS;
        fieldList = new ArrayList<>();
        roomList = new ArrayList<>();
    }

    /**
     * Builds a room of a type
     * @param roomType The type of the room
     * @param roomName The name of the room
     */
    void buildRoom(String roomType, String roomName) {
        // check if
        for (AbstractRoom room : roomList) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                System.out.println("Fail to build " + roomType +
                        " , cause by : the room name is exits ");
                return;
            }
        }
        // continue
        if (roomType.equalsIgnoreCase("livingroom")) {
            LivingRoom livingRoom = new LivingRoom();
            livingRoom.setName(roomName);
            roomList.add(livingRoom);
            System.out.println("Success to build : " + roomName);
        } else if(roomType.equalsIgnoreCase("bedroom")) {
            BedRoom bedRoom = new BedRoom();
            bedRoom.setName(roomName);
            roomList.add(bedRoom);
            System.out.println("Success to build : " + roomName);
        } else if (roomType.equalsIgnoreCase("kithchenroom")) {
            KitchenRoom kitchenRoom = new KitchenRoom();
            kitchenRoom.setName(roomName);
            roomList.add(kitchenRoom);
            System.out.println("Success to build : " + roomName);
        } else {
            System.out.println("Fail to build " + roomType +
                    " , cause by : there is not exits " + roomType);
        }
    }

    /**
     * Gets room object in the HappyFarm
     * @param roomName The name of room
     * @return AbstractRoom The object of room
     */
    AbstractRoom getRoom(String roomName) {
        for (AbstractRoom room : roomList) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                System.out.println("Success to find " + roomName);
                return room;
            }
        }
        if (roomName.equalsIgnoreCase("storageroom")) {
            System.out.println("Success to find " + roomName);
            return StorageRoom.getInstance();
        }
        System.out.println("Fail to find " + roomName + " , cause by : the room is not exits");
//        throw new NullPointerException("not find");
        return null;
    }

    /**
     * Decorates the room
     * @param action The name of action
     * @param roomName The name of room
     */
    void decorateRoom(String roomName, String action) {
        if (action.equalsIgnoreCase("brush")) {
            AbstractRoom room = getRoom(roomName);
            if (null != room) {
                BrushDecoratorRoom brushDecoratorRoom = new BrushDecoratorRoom(room);
                brushDecoratorRoom.show();
            } else {
                System.out.println("Fail to decorator " + roomName +
                        " , cause by : the room is not exits");
            }
        } else {
            System.out.println("Fail to decorator " + roomName +
                    " , cause by : the action is not exits");
        }
    }

    /**
     * Returns a single instance of HappyFarm
     * @return A single instance of HappyFarm
     */
    public static HappyFarm getInstance() {
        HappyFarm inst = instance;
        if (inst == null) {
            synchronized (HappyFarm.class) {
                inst = instance;
                if (inst == null) {
                    inst = new HappyFarm();
                    instance = inst;
                }
            }
        }

        return inst;
    }

    /**
     * Increases the funds by some amount
     * @param amount The amount by which the funds are increased
     * @return The amount of the funds after the increase
     */
    double moneyIn(double amount) {
        this.funds += amount;
        return this.funds;
    }

    /**
     * Decreases the funds by some amount
     * @param amount The amount by which the funds are decreased
     * @return The amount of the funds after the decrease
     */
    double moneyOut(double amount) {
        this.funds -= amount;
        return this.funds;
    }

    public double getFunds() {
        return this.funds;
    }

    /**
     * Shows the information of the field in this farm
     */
    public void showFieldsInformation() {
        ConcreteFieldVisitor visitor = new ConcreteFieldVisitor();
        for (AbstractField field : fieldList) {
            field.acceptVisitor(visitor);
        }
    }

    /**
     * Adds a field into the list of fields in this farm
     * @param field The field to be added
     */
    void addField(AbstractField field) {
        fieldList.add(field);
    }

    /**
     * Returns the total capacity of the creature in this farm
     * @param clazz The class of the creature
     * @return The total capacity of the creature in this farm
     */
    int getCreatureCapacity(Class clazz) {
        int totalCapacity = 0;

        for (AbstractField field : fieldList) {
            if (field.isCreatureMatch(clazz)) {
                totalCapacity += field.getCapacity() - field.creatureCount();
            }
        }

        return totalCapacity;
    }

    /**
     * Adds the creatures into the fields
     * @param list The list of the creatures
     * @throws MethodExposedException if the method is exposed to the outside package
     */
    public void addCreatures(List<AbstractCreature> list) throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        Deque<AbstractCreature> deque = new ArrayDeque<AbstractCreature>(list);

        for (AbstractField field : fieldList) {
            if (field.isCreatureMatch(list.get(0).getClass())) {
                if (field instanceof AbstractPen) {
                    while (field.getCapacity() - field.creatureCount() > 0) {
                        AbstractAnimal animal = (AbstractAnimal) deque.poll();
                        // If the deque is empty
                        if (animal == null) {
                            return;
                        } else {
                            ((AbstractPen) field).addAnimal(animal);
                        }
                    }
                } else if (field instanceof AbstractFarmland) {
                    while (field.getCapacity() - field.creatureCount() > 0) {
                        AbstractPlant plant = (AbstractPlant) deque.poll();

                        // If the deque is empty
                        if (plant == null) {
                            return;
                        } else {
                            ((AbstractFarmland) field).addPlant((AbstractPlant) deque.poll());
                        }
                    }
                } else {
                    // TODO: handle...
                    System.out.println("Field not recognisable.");
                }
            }
        }

        // TODO: Throws exception indicating the capacity is not enough
    }

    /**
     * Saves Farm State: HappyFarm(Funds, Field, Room List) and StorageRoom(ProductsList)
     */
    public void save() {
        try {
            Double clonedFunds = this.funds;

            //serializable

            ByteArrayOutputStream byteOutField = new ByteArrayOutputStream();
            ObjectOutputStream outField = new ObjectOutputStream(byteOutField);
            outField.writeObject(this.fieldList);
            ByteArrayInputStream byteInField = new ByteArrayInputStream(
                    byteOutField.toByteArray());
            ObjectInputStream inField = new ObjectInputStream(byteInField);
            List<AbstractField> clonedFieldList = (List<AbstractField>) inField.readObject();

            ByteArrayOutputStream byteOutRoom = new ByteArrayOutputStream();
            ObjectOutputStream outRoom = new ObjectOutputStream(byteOutRoom);
            outRoom.writeObject(this.roomList);
            ByteArrayInputStream byteInRoom = new ByteArrayInputStream(
                    byteOutRoom.toByteArray());
            ObjectInputStream inRoom = new ObjectInputStream(byteInRoom);
            List<AbstractRoom> clonedRoomList = (List<AbstractRoom>) inRoom.readObject();

            StorageRoom storageRoom = StorageRoom.getInstance();
            List<AbstractProduct> productsList = storageRoom.getProducts();

            ByteArrayOutputStream byteOutProducts = new ByteArrayOutputStream();
            ObjectOutputStream outProducts = new ObjectOutputStream(byteOutProducts);
            outProducts.writeObject(productsList);
            ByteArrayInputStream byteInProducts = new ByteArrayInputStream(
                    byteOutProducts.toByteArray());
            ObjectInputStream inProducts = new ObjectInputStream(byteInProducts);
            List<AbstractProduct> clonedProductsList = (List<AbstractProduct>) inProducts.readObject();


            Memento memento = new Memento();
            memento.setState(clonedFunds, clonedFieldList, clonedRoomList, clonedProductsList);

            Memento.addState(memento);

            System.out.println("Save HappyFarm success.");
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Reloads state of HappyFarm and Storage
     */
    public void reload() {
        Memento memento = Memento.popState();

        this.funds = memento.getFunds();
        this.fieldList = memento.getFieldList();
        this.roomList = memento.getRoomList();

        StorageRoom storageRoom = StorageRoom.getInstance();
        storageRoom.setProducts(memento.getProductsList());

        System.out.println("Reload HappyFarm success");
    }

    /**
     * Returns a list of fields in this farm
     * @return A list of fields in this farm
     * @throws MethodExposedException if the method is exposed to the outside package
     */
    public List<AbstractField> getFieldList() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        return fieldList;
    }

}
