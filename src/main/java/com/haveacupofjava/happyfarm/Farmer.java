package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.room.Mop;
import com.haveacupofjava.happyfarm.room.Wipe;
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
     * farmer storage produce
     * @param produce
     */
    public void storageProduce(AbstractProduce produce){
        StorageRoom storageRoom = StorageRoom.getInstance();
        storageRoom.storage(produce);
        System.out.println("Show all products in the storage room :");
        storageRoom.show();
    }

    public void cleanRoom(AbstractRoom abstractRoom, String action){
        if(action.equalsIgnoreCase("wipe")){
            abstractRoom.setCleanable(new Wipe());
            abstractRoom.clean();
        }else if(action.equalsIgnoreCase("mop")){
            abstractRoom.setCleanable(new Mop());
            abstractRoom.clean();
        }else {
            System.out.println("Fail to clean, cause by there is no " + action + " action");
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
