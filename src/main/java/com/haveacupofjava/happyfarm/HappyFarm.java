package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
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

    private Double funds;

    private List<AbstractField> fieldList;

    private List<AbstractRoom> roomList;

    private static final double INITIAL_FUNDS = 1000.0;

    private HappyFarm() {
        funds = INITIAL_FUNDS;
        fieldList = new ArrayList<>();
        roomList = new ArrayList<>();
    }

    /**
     * build a room
     * @param roomType
     * @param roomName
     */
    void buildRoom(String roomType, String roomName) {
        // check if
        for (AbstractRoom room : roomList) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                System.out.println("Fail to build " + roomType + " , cause by : the room name is exits ");
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
            System.out.println("Fail to build " + roomType + " , cause by : there is not exits " + roomType);
        }
    }

    /**
     * Get room object in the HappyFarm
     * @param roomName The name of room
     * @return AbstractRoom The object of room
     */
    AbstractRoom getRoom(String roomName){
        for (AbstractRoom room : roomList){
            if(room.getName().equalsIgnoreCase(roomName)){
                System.out.println("Success to find " + roomName);
                return room;
            }
        }
        if(roomName.equalsIgnoreCase("storageroom")){
            System.out.println("Success to find " + roomName);
            return StorageRoom.getInstance();
        }
        System.out.println("Fail to find " + roomName + " , cause by : the room is not exits");
//        throw new NullPointerException("not find");
        return null;
    }

    /**
     * Decorator the room
     * @param action The name of action
     * @param roomName The name of room
     */
    void decoratorRoom(String roomName, String action) {
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
     * save Farm State: HappyFarm(Funds, Field, Room List) and StorageRoom(ProductsList)
     */
    void save() {
        try {
            Double clonedFunds = this.funds;

            //serializable
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(
                    byteOut.toByteArray());

            out.writeObject(this.fieldList);
            ObjectInputStream in = new ObjectInputStream(byteIn);
            List<AbstractField> clonedFieldList = (List<AbstractField>) in.readObject();

            out.writeObject(this.roomList);
            in = new ObjectInputStream(byteIn);
            List<AbstractRoom> clonedRoomList = (List<AbstractRoom>) in.readObject();

            StorageRoom storageRoom = StorageRoom.getInstance();
            List<AbstractProduct> productsList = storageRoom.getProducts();
            out.writeObject(productsList);
            in = new ObjectInputStream(byteIn);
            List<AbstractProduct> clonedProductsList = (List<AbstractProduct>) in.readObject();

            Memento memento = new Memento();
            memento.setState(clonedFunds, clonedFieldList, clonedRoomList, clonedProductsList);

            // TODO
            // and other attributes (must implement serializable)
            // and need define some functions in Memento (set..., get...)

            Memento.addState(memento);

            System.out.println("Save HappyFarm success.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * undo, reload state of HappyFarm and Storage
     */
    void reload() {

        Memento memento = Memento.popState();

        this.funds = memento.getFunds();
        this.fieldList = memento.getFieldList();
        this.roomList = memento.getRoomList();

        StorageRoom storageRoom = StorageRoom.getInstance();
        storageRoom.setProducts(memento.getProductsList());

        System.out.println("Reload HappyFarm success");
    }

    /**
     *
     * @return
     * @throws MethodExposedException if the method is exposed to the outside package
     */
    public List<AbstractField> getFieldList() throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        return fieldList;
    }

}
