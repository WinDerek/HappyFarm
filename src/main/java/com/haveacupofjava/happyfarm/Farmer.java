package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.factory.AbstractAnimalFactory;
import com.haveacupofjava.happyfarm.factory.AbstractPlantFactory;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.room.Mop;
import com.haveacupofjava.happyfarm.room.Wipe;
import com.haveacupofjava.happyfarm.room.storage.AbstractBox;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;
import com.haveacupofjava.happyfarm.store.ProxyStore;
import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.AbstractFieldBuilder;
import com.haveacupofjava.happyfarm.field.Director;
import com.haveacupofjava.happyfarm.trade.FactoryMediator;
import com.haveacupofjava.happyfarm.trade.Tradable;

import java.util.ArrayList;
import java.util.List;

public class Farmer implements Observer, Tradable {

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

    public void payMoney(double amount) throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        HappyFarm happyFarm = HappyFarm.getInstance();
        System.out.println(Farmer.class.getName() + ".payMoney(" + amount + ") called.");
        System.out.println("Current amount of money is: " + happyFarm.getFunds() + ".");
        System.out.println("After paying, the amount of money is: " +
                happyFarm.moneyOut(amount));
    }

    public void gainMoney(double amount) throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        HappyFarm.getInstance().moneyIn(amount);
    }

    /**
     * farmer buy product from proxy store
     * @param productName
     * @param number
     */
    public void buyProduct(String productName, int number){
        ProxyStore proxyStore = ProxyStore.getInstance();
        AbstractProduct product = proxyStore.buy(productName);
        // not enough
        if(HappyFarm.getInstance().getFunds() <= product.getPrice() * number){
            System.out.println("Fail to buy : " + productName + " cause by : there is not enough money");
            return;
        }
        // storage the product
        if(!(product instanceof NullProduct)){
            StorageRoom.getInstance().addProduct(product);
        }
        HappyFarm.getInstance().moneyOut(product.getPrice() * number);
        System.out.println("The consumption cost " + product.getPrice() * number + "$");
    }

    /**
     * build a room
     * @param roomType
     * @param roomName
     */
    public void buildRoom(String roomType, String roomName){
        HappyFarm.getInstance().buildRoom(roomType, roomName);
    }

    /**
     * get room object in the HappyFarm
     * @param roomName
     * @return AbstractRoom
     */
    public AbstractRoom getRoom(String roomName){
        return HappyFarm.getInstance().getRoom(roomName);
    }

    /**
     * farmer storage produce
     * @param produce
     */
    public void storageProduce(AbstractProduce produce){
        StorageRoom storageRoom = StorageRoom.getInstance();
        storageRoom.storage(produce);
        System.out.println("Show all products in the storage room : ");
        storageRoom.show();
    }

    /**
     * get produce name
     * @param produceName
     * @return
     */
    public List<AbstractProduce> getProduce(Class clazz , int number){
        List<AbstractProduce> produceList = new ArrayList<>();
        int mNumber = 0;
        StorageRoom storageRoom = StorageRoom.getInstance();
        // check
        for(AbstractProduct product : storageRoom.getProducts()){
            if (product instanceof AbstractBox){
                for( AbstractProduce produce : ((AbstractBox) product).getProduces()){
                    //System.out.println(produce.getName());
                    if(clazz.getSimpleName().toLowerCase().equals(produce.getName())){
                        mNumber++;
                    }
                }
            }
        }
        if(mNumber < number){
            System.out.println("Fail to get : " + clazz.getSimpleName() + ", cause by : storage is not enough produce");
            return null;
        }
        // ok
        mNumber = 0;
        int index = 0;
        List<Integer> integers = new ArrayList<>();
        for(AbstractProduct product : storageRoom.getProducts()){
            //System.out.println(storageRoom.getProducts().size() + " " + product.getName());
            if (product instanceof AbstractBox){
                for( AbstractProduce produce : ((AbstractBox) product).getProduces()){
                    if(clazz.getSimpleName().toLowerCase().equals(produce.getName())){
                        mNumber++;
                        produceList.add(produce);
                        integers.add(index);
                        if(mNumber == number){
                            int count = 0;
                            for (Integer integer : integers){
                                storageRoom.getProducts().remove(integer - count);
                                count++;
                            }
                            System.out.println("Success to get " + number + " " + clazz.getSimpleName() + "s");
                            return produceList;
                        }
                    }
                }
            }
            index++;
        }
        System.out.println("Fail to get produce, cause by : the " + clazz.getSimpleName() +" is not exist");
        return null;
    }
    /**
     * decorator the room
     * @param action
     * @param roomName
     */
    public void decoratorRoom( String roomName, String action){
        HappyFarm.getInstance().decoratorRoom(roomName, action);
    }

    /**
     * clean the room
     * @param roomName
     * @param action
     */
    public void cleanRoom(String roomName, String action){
        AbstractRoom abstractRoom = getRoom(roomName);
        if(null == abstractRoom){
            System.out.println("Fail to clean, cause by : the " + roomName + " is not exist ");
            return;
        }
        if(action.equalsIgnoreCase("wipe")){
            abstractRoom.setCleanable(new Wipe());
            abstractRoom.setCleanable(new Wipe());
            abstractRoom.clean();
        }else if(action.equalsIgnoreCase("mop")){
            abstractRoom.setCleanable(new Mop());
            abstractRoom.clean();
        }else {
            System.out.println("Fail to clean, cause by : there is no " + action + " action");
            System.out.println("List actions : ");
            System.out.println("1.wipe");
            System.out.println("2.mop");
        }
    }
    /**
     * show all items in the store
     */
    public void goShopping(){
        ProxyStore proxyStore = ProxyStore.getInstance();
        proxyStore.show();
    }

    /**
     * Buys animal(s) from an animal factory through mediator
     * @param factory An instance of concrete animal factory
     * @param number  The number of animal(s) to be bought
     */
    public void buyAnimal(AbstractAnimalFactory factory, int number) throws Exception {
        HappyFarm happyFarm = HappyFarm.getInstance();

        AbstractAnimal animal = factory.getAnimal();

        if (number > happyFarm.getCreatureCapacity(animal.getClass())) {
            throw new Exception("NoEnoughCapacityException");
        }

        if (happyFarm.getFunds() < animal.getSellingPrice() * number) {
            throw new Exception("NoEnoughMoneyException");
        }

        FactoryMediator factoryMediator = new FactoryMediator();
        factoryMediator.setBuyer(this);
        factoryMediator.setSeller(factory);
        factoryMediator.setTradeInfo(number);
        factoryMediator.handleTrade();

        System.out.println("buy animal success");
    }

    /**
     * Buys plant(s) from an plant factory through mediator
     * @param factory The instance of concrete plant factory
     * @param number  The number of plant(s) to be bought
     */
    public void buyPlant(AbstractPlantFactory factory, int number) throws Exception {
        HappyFarm happyFarm = HappyFarm.getInstance();

        AbstractPlant plant = factory.getPlant();

        if (number > happyFarm.getCreatureCapacity(plant.getClass())) {
            throw new Exception("NoEnoughCapacityException");
        }

        if (happyFarm.getFunds() < plant.getSellingPrice() * number) {
            throw new Exception("NoEnoughMoneyException");
        }

        payMoney(plant.getSellingPrice() * number);

        FactoryMediator factoryMediator = new FactoryMediator();
        factoryMediator.setBuyer(this);
        factoryMediator.setSeller(factory);
        factoryMediator.setTradeInfo(number);
        factoryMediator.handleTrade();

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
                System.out.println("some sheep have produced milk");
            }
            break;
            case "PigProduceMilk": {
                System.out.println("some pigs have produced milk");
            }
            break;
            case "WheatProduceFruit": {
                System.out.println("some wheat have produced fruit");
            }
            break;

            default: {
                System.out.println(notification);
            }
        }
    }

    /**
     *
     * @param builder
     */
    public void buyField(AbstractFieldBuilder builder){
        Director director = new Director(builder);
        director.constructField();
        AbstractField field = builder.getField();
        HappyFarm.getInstance().addField(field);
    }

}
