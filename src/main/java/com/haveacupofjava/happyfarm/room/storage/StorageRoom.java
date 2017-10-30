package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.product.NullToolProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.security.PackageChecker;
import com.haveacupofjava.happyfarm.store.ProxyStore;


import java.util.ArrayList;
import java.util.List;

public class StorageRoom extends AbstractRoom {

    private static final String TAG = StorageRoom.class.getSimpleName();

    private static StorageRoom storageRoom;

    private StorageRoom() {
        setName("storageRoom");
    }

    public List<AbstractProduct> getProducts(){
        return products;
    }

    /**
     * reset products list
     * only for HappyFarm.reload
     */
    public void setProducts(List<AbstractProduct> list){
        products = list;
    }

    @Override
    public void show() {
        if (null == products) {
            System.out.println("There is nothing in the room");
        } else {
            for (AbstractProduct product : products) {
                if (product instanceof AbstractBox) {
                    System.out.println("box : " + product.getName() + ", inside items :");
                    showBox((AbstractBox) product);
                } else {
                    System.out.println("product: " + product.getName());
                }
            }
        }
    }

    /**
     * Recursion print the items in the box
     * @param box the object of box
     */
    public void showBox(AbstractBox box) {
        // show all the products
        for (AbstractProduce produce : box.getProduces()) {
            System.out.println("    produce: " + produce.getName()
                    + " in the " + box.getName());
        }
    }

    /**
     * Returns store room instance
     * @return StorageRoom
     */
    public static StorageRoom getInstance() {
        if (null == storageRoom) {
            storageRoom = new StorageRoom();
        }
        return storageRoom;
    }

    /**
     * If the tool is not exist, will buy it from store.
     * If fail to buy, return one not available object
     * @param tool The name of tool
     * @return Tool the object of AbstractTool
     */
    public AbstractTool getTool(String tool) {
        if (products == null) {
            products = new ArrayList<>();
        }
        // get tool from store
        for (AbstractProduct product : products) {
            if ((product instanceof AbstractTool) && product.getName().equals(tool)) {
                System.out.println("Success to get " + tool + " from store");
                return (AbstractTool) product;
            }
        }
        System.out.println("There is not " + tool + " in the store");
        System.out.println("Will buy " + tool + " from store");
        // there is no tool int the store room and buy it from proxy store
        ProxyStore proxyStore = ProxyStore.getInstance();
        AbstractProduct product = proxyStore.buy(tool);
        // check
        if (product instanceof NullProduct) {
            System.out.println("Fail to get : " + tool +
                    ", caused by: the store did not sell " + tool);
            return new NullToolProduct();
        }
        else if (product instanceof AbstractTool) {
            System.out.println("Success to get : " + tool);
            products.add(product);
            return (AbstractTool) product;
        } else {
            System.out.println("Fail to get : " + tool + ", caused by: the " + tool +
                    " is not tool");
            return new NullToolProduct();
        }
    }

    // TODO: Whether this method should be exposed to clients
//    /**
//     * Stores a produce into this storage room
//     * @param produce The produce to be stored
//     * @throws MethodExposedException if this method is exposed to outside packages
//     */
//    public void store(AbstractProduce produce) throws MethodExposedException {
//        // Check if the caller method is allowed to call this method
//        PackageChecker.checkPackage();
//
//        NormalBox normalBox = new NormalBox();
//        normalBox.store(products, produce);
//
//        System.out.println(TAG + ": " + produce.toString() + " is stored in " +
//                normalBox.toString() + " in " + toString());
//    }

    /**
     * Stores a produce into this storage room
     * @param produce The produce to be stored
     */
    public void store(AbstractProduce produce) {
        NormalBox normalBox = new NormalBox();
        normalBox.store(products, produce);

        System.out.println(TAG + ": " + produce.getClass().getSimpleName() + "@" +
                produce.hashCode() + " is stored in " + normalBox.getClass().getSimpleName() +
                "@" + normalBox.hashCode() + " in " + getClass().getSimpleName() + "@" +
                hashCode());
    }

    /**
     * Cleans the room
     */
    @Override
    public void clean(String action) {
        super.clean(action);
    }

}
