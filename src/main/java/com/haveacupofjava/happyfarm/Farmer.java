package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.factory.AbstractPlantFactory;
import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.AbstractFieldBuilder;
import com.haveacupofjava.happyfarm.field.Director;
import com.haveacupofjava.happyfarm.factory.AbstractAnimalFactory;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;

public class Farmer implements Observer {

    private static Farmer instance;

    private Farmer() {}

    /**
     * Returns a single instance of Farmer
     * @return A single instance of Farmer
     */
    public static Farmer getInstance() {
        Farmer inst = instance;
        if (inst == null) {
            synchronized (Farmer.class) {
                inst = instance;
                if (inst == null) {
                    inst = new Farmer();
                    instance = inst;
                }
            }
        }

        return inst;
    }

    private void payMoney(double amount) {
        HappyFarm happyFarm = HappyFarm.getInstance();
        System.out.println(Farmer.class.getName() + ".payMoney(" + amount + ") called.");
        System.out.println("Current amount of money is: " + happyFarm.getFunds() + ".");
        System.out.println("After paying, the amount of money is: " +
                happyFarm.moneyOut(amount));
    }

    private void gainMoney(double amount) {
        HappyFarm.getInstance().moneyIn(amount);
    }

    public void buyAnimal(AbstractAnimalFactory factory, int number) throws Exception {
        HappyFarm happyFarm = HappyFarm.getInstance();

        AbstractAnimal animal = factory.getAnimal();

        if (number > happyFarm.getCreatureCapacity(animal.getClass())) {
            throw new Exception("NoEnoughCapacityException");
        }
        if (happyFarm.getFunds() < animal.getSellingPrice() * number) {
            throw new Exception("NoEnoughMoneyException");
        }

        this.payMoney(animal.getSellingPrice() * number);

        //TODO: Mediator adds animals to field

        System.out.println("buy animal success");
    }

    public void buyPlant(AbstractPlantFactory factory, int number) throws Exception {
        HappyFarm happyFarm = HappyFarm.getInstance();

        AbstractPlant plant = factory.getPlant();

        if (number > happyFarm.getCreatureCapacity(plant.getClass())) {
            throw new Exception("NoEnoughCapacityException");
        }
        if (happyFarm.getFunds() < plant.getSellingPrice() * number) {
            throw new Exception("NoEnoughMoneyException");
        }

        this.payMoney(plant.getSellingPrice() * number);

        //TODO: Mediator adds plants to field

        System.out.println("buy plant success");
    }

    /**
      * When the farmer gets a notification, he does something
      * @param notification type of notification
      * @author Yichao Wu
      */
    @Override
    public void update(String notification) {
        switch (notification) {
            case "SheepProduceMilk": {
                System.out.println("some sheep has produced milk");
            }
            break;

            default: {
                System.out.println(notification);
            }
        }
    }

    public void buyField(AbstractFieldBuilder builder){

        Director director = new Director(builder);
        director.constructField();

        AbstractField field = builder.getField();

        // TODO
        // HappyFarm.pushFiled(field);
        // farmer.buyField(new Builder);
    }

}
