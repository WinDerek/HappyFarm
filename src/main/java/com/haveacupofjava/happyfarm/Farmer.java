package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.creature.AbstractAnimal;
import com.haveacupofjava.happyfarm.creature.AbstractPlant;
import com.haveacupofjava.happyfarm.factory.AbstractAnimalFactory;
import com.haveacupofjava.happyfarm.factory.AbstractPlantFactory;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.room.Cleanable;
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
import com.haveacupofjava.happyfarm.task.AnimalManagerHandler;
import com.haveacupofjava.happyfarm.task.PlantManagerHandler;
import com.haveacupofjava.happyfarm.task.Request;
import com.haveacupofjava.happyfarm.task.RequestParsingException;
import com.haveacupofjava.happyfarm.trade.FactoryMediator;
import com.haveacupofjava.happyfarm.trade.Market;
import com.haveacupofjava.happyfarm.trade.MarketMediator;
import com.haveacupofjava.happyfarm.trade.Tradable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farmer implements Observer, Tradable, Serializable{

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

    /**
     * Pays some amount of money
     * @param amount The amount of money that this farmer should pay
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void payMoney(double amount) throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        HappyFarm happyFarm = HappyFarm.getInstance();
        System.out.println(Farmer.class.getName() + ".payMoney(" + amount + ") called.");
        System.out.println("Current amount of money is: " + happyFarm.getFunds() + ".");
        System.out.println("After paying, the amount of money is: " +
                happyFarm.moneyOut(amount));
    }

    /**
     * Gains some amount of money
     * @param amount The amount of money that this farmer should pain
     * @throws MethodExposedException if this method is exposed to outside packages
     */
    public void gainMoney(double amount) throws MethodExposedException {
        // Checks if the caller method is allowed to call this method
        PackageChecker.checkPackage();

        HappyFarm.getInstance().moneyIn(amount);
    }

    /**
     * Buys products from proxy store
     * @param productName The name of the products to buy
     * @param number The number of the products to buy
     */
    public void buyProduct(String productName, int number) {
        ProxyStore proxyStore = ProxyStore.getInstance();
        AbstractProduct product = proxyStore.buy(productName);

        // If the farmer cannot afford the products
        double neededAmount = product.getPrice() * number;
        double funds = HappyFarm.getInstance().getFunds();
        if (funds <= neededAmount) {
            System.out.println("Fail to buy : " + productName +
                    " caused by : there is not enough money. The farmer only have " + funds +
                    ", but the total amount of money should be paid is " + neededAmount + ".");
            return;
        }

        // Store the products in the storage room
        if (!(product instanceof NullProduct)) {
            StorageRoom.getInstance().addProduct(product);
        }

        // Let the farmer pays the money
        HappyFarm.getInstance().moneyOut(product.getPrice() * number);

        System.out.println("The consumption cost " + product.getPrice() * number + "$");
    }

    /**
     * Builds up a room
     * @param roomType The type of the room
     * @param roomName The name of the room
     */
    public void buildRoom(String roomType, String roomName) {
        HappyFarm.getInstance().buildRoom(roomType, roomName);
    }

    /**
     * Gets a room specified by the {@code roomName} in the {@code HappyFarm}
     * @param roomName The name of the room
     * @return AbstractRoom
     */
    public AbstractRoom getRoom(String roomName) {
        return HappyFarm.getInstance().getRoom(roomName);
    }

    /**
     * Get some produces
     * @param clazz Class type
     * @param number The number of produce
     * @return null If the get operation fails
     */
    public List<AbstractProduce> getProduce(Class clazz, int number) {
        if(number <= 0){
            System.out.println("Please enter a valid value");
            return null;
        }
        List<AbstractProduce> produceList = new ArrayList<>();
        int mNumber = 0;
        StorageRoom storageRoom = StorageRoom.getInstance();
        // check
        for (AbstractProduct product : storageRoom.getProducts()) {
            if (product instanceof AbstractBox) {
                for (AbstractProduce produce : ((AbstractBox) product).getProduces()) {
                    if (clazz.getSimpleName().equalsIgnoreCase(produce.getName())) {
                        mNumber++;
                    }
                }
            }
        }
        if (mNumber < number) {
            System.out.println("Fail to get : " + clazz.getSimpleName() + ", cause by : storage room is not enough produce");
            return null;
        }
        // ok
        mNumber = 0;
        // use iterator to remove object
        Iterator iterator = storageRoom.getProducts().iterator();
        while (iterator.hasNext()){
            AbstractProduct product = (AbstractProduct) iterator.next();
            if(product instanceof AbstractBox){
                for (AbstractProduce produce : ((AbstractBox) product).getProduces()) {
                    if (clazz.getSimpleName().equalsIgnoreCase(produce.getName())) {
                        produceList.add(produce);
                        iterator.remove();
                        mNumber++;
                        if (mNumber == number) {
                            System.out.println("Success to get " + number + " " +
                                    clazz.getSimpleName() + "s");
                            return produceList;
                        }
                    }
                }
            }
        }
        System.out.println("Fail to get produce, cause by : the class " +
                clazz.getSimpleName() + " does not exist");
        return null;
    }

    /**
     * Decorates the room
     * @param action The name of action
     * @param roomName The name of room
     */
    public void decorateRoom(String roomName, String action) {
        HappyFarm.getInstance().decorateRoom(roomName, action);
    }

    /**
     * Cleans the room
     * @param roomName The name of room
     * @param action The action of doing
     */
    public void cleanRoom(String roomName, String action){
        AbstractRoom abstractRoom = getRoom(roomName);
        if (null == abstractRoom) {
            System.out.println("Fail to clean, cause by : the '" + roomName + "' is not exist ");
            return;
        }
        abstractRoom.addCleanable(new Wipe());
        abstractRoom.addCleanable(new Mop());
        abstractRoom.clean(action);
    }

    /**
     * Goes shopping
     * Shows all items in the store
     */
    public void goShopping(){
        ProxyStore.getInstance().show();
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
            case "HenProduceEgg": {
                System.out.println("some hens have produced eggs");
            }
            break;

            default: {
                System.out.println(notification);
            }
        }
    }

    /**
     * Buys a field and adds it into the farm
     * @param builder A builder of the field
     */
    public void buyField(AbstractFieldBuilder builder) {
        Director director = new Director(builder);
        director.constructField();
        AbstractField field = builder.getField();
        HappyFarm.getInstance().addField(field);
    }

    /**
     * Sells some amount of produces
     * @param clazz The Class of the produce
     * @param number The amount of the produce to sell
     * @return True if the sell is successful, otherwise returns false.
     */
    public boolean sellProduce(Class clazz, int number) {
        List<AbstractProduce> list = getProduce(clazz, number);

        // Checks if the get operation fails
        if (list == null) {
            System.out.println("Sell produce fails due to the failure of getting the produces.");
            return false;
        }

        MarketMediator marketMediator = new MarketMediator();
        marketMediator.setSeller(this);
        marketMediator.setBuyer(Market.getInstance());
        marketMediator.setProduceList(list);
        marketMediator.handleTrade();

        System.out.println("Trade completed.");

        return true;
    }

    /**
     * Handles a request
     * @param request The request to be handled
     * @throws RequestParsingException if the request is not parsable
     */
    public void handleRequest(Request request) throws RequestParsingException {
        AnimalManagerHandler animalManagerHandler = new AnimalManagerHandler();
        PlantManagerHandler plantManagerHandler = new PlantManagerHandler();
        animalManagerHandler.setNext(plantManagerHandler);
        animalManagerHandler.handleRequest(request);
    }

}
