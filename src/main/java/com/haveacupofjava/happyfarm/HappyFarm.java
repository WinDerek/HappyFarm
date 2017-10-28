package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.room.*;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.visitor.ConcreteFieldVisitor;
import com.sun.net.httpserver.Authenticator;

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
        fieldList = new ArrayList<AbstractField>();
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
     * get room object in the HappyFarm
     * @param roomName
     * @return AbstractRoom
     */
    AbstractRoom getRoom(String roomName){
        for (AbstractRoom room : roomList){
            if(room.getName().equalsIgnoreCase(roomName)){
                System.out.println("success to get " + roomName);
                return room;
            }
        }
        if(roomName.equalsIgnoreCase("storageroom")){
            System.out.println("success to get " + roomName);
            return StorageRoom.getInstance();
        }
        System.out.println("Fail to get " + roomName + " , cause by : the room is not exits");
//        throw new NullPointerException("not find");
        return null;
    }

    /**
     * decorator the room
     * @param action
     * @param roomName
     */
    void decoratorRoom(String roomName, String action){
        if(action.equalsIgnoreCase("brush")){
            AbstractRoom room = getRoom(roomName);
            if(null != room){
                BrushDecoratorRoom brushDecoratorRoom = new BrushDecoratorRoom(room);
                brushDecoratorRoom.show();
            }else{
                System.out.println("Fail to decorator " + roomName + " , cause by : the room is not exits");
            }
        }else{
            System.out.println("Fail to decorator " + roomName + " , cause by : the action is not exits");
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

}
