package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.store.ProxyStore;

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
     * show all items in the store
     */
    public void goShopping(){
        ProxyStore proxyStore = ProxyStore.getInstance();
        proxyStore.show();
    }

    public void buyAnimal(Class clazz, int number) {
    }

    public void buyPlant(Class clazz, int number) {
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

}
