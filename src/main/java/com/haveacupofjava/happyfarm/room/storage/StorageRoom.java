package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.product.NullProduct;
import com.haveacupofjava.happyfarm.product.NullToolProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.store.ProxyStore;


import java.util.ArrayList;
import java.util.List;

public class StorageRoom extends AbstractRoom {

    private static StorageRoom storageRoom;

    private StorageRoom() {
        setName("storageRoom");
    }

    public List<AbstractProduct> getProducts(){
        return products;
    }
    /**
     * override show
     * show the items int the box
     */
    @Override
    public void show() {
        //super.show();
        if(null == products){
            System.out.println("there is nothing in the room");
        } else {
            for (AbstractProduct product : products) {
                if (product instanceof AbstractBox) {
                    System.out.println("product: " + product.getName() + ", inside items :");
                    showBox((AbstractBox) product);
                } else {
                    System.out.println("product: " + product.getName());
                }
            }
        }

    }

    /**
     * recursion print the items in the box
     * @param box
     */
    public void showBox(AbstractBox box) {
        // show all the products
        for (AbstractProduce produce : box.getProduces()) {
            System.out.println("    produce: " + produce.getName()
                    + " in the " + box.getName());
//            if (product instanceof AbstractBox) {
//                showBox((AbstractBox) product);
//            } else {
//                System.out.println("product: " + produce.getName()
//                        + " in the " + box.getName());
//            }
        }
    }

    /**
     * return storage room instant
     * @return StorageRoom
     */
    public static StorageRoom getInstance() {
        if (null == storageRoom) {
            storageRoom = new StorageRoom();
        }
        return storageRoom;
    }

    /**
     * return tool object
     * @param tool name
     * @return Tool
     */
    public AbstractTool getTool(String tool) {
        if (products == null) {
            products = new ArrayList<>();
        }
        // get tool from storage
        for (AbstractProduct product : products) {
            if ((product instanceof AbstractTool) && product.getName().equals(tool)) {
                System.out.println("Success to get " + tool + " from storage");
                return (AbstractTool) product;
            }
        }
        System.out.println("There is not " + tool + " in the storage");
        System.out.println("Will buy " + tool + " from store");
        // there is no tool int the storage room and buy it from proxy store
        ProxyStore proxyStore = ProxyStore.getInstance();
        AbstractProduct product = proxyStore.buy(tool);
        // check
        if (product instanceof NullProduct) {
            System.out.println("Fail to get : " + tool + ", caused by: the store did not sell " + tool);
            return new NullToolProduct();
        }
        else if (product instanceof AbstractTool) {
            System.out.println("Success to get : " + tool);
            products.add(product);
            return (AbstractTool) product;
        } else {
            System.out.println("Fail to get : " + tool + ", caused by: the " + tool + " is not tool");
            return new NullToolProduct();
        }
    }

    /**
     * storage produce
     * @param produce AbstractProduce
     */
    public void storage(AbstractProduce produce) {
        // TODO: Control the permissions better
        NormalBox normalBox = new NormalBox();
        normalBox.storage(products, produce);
        products.add(normalBox);
    }

    @Override
    public void clean() {
        if (null != cleanable) {
            cleanable.clean();
        } else {
            System.out.println("You do not add clean way");
        }
    }

}
