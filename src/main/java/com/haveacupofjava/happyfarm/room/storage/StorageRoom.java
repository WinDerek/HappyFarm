package com.haveacupofjava.happyfarm.room.storage;

import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.room.AbstractRoom;
import com.haveacupofjava.happyfarm.store.ProxyStore;

public class StorageRoom extends AbstractRoom {

    private static StorageRoom storageRoom;

    private StorageRoom(){
    }

    @Override
    public void show() {
        super.show();
    }

    /**
     * return storage room instant
     * @return StorageRoom
     */
    public static StorageRoom getInstance() {
        if (null != storageRoom) {
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
            return null;
        }
        // get tool from storage
        for (AbstractProduct product : products) {
            if (product instanceof AbstractTool && product.getName().equals(tool)) {
                return (AbstractTool) product;
            }
        }
        // there is no tool int the storage room and buy it from proxy store
        ProxyStore proxyStore = new ProxyStore();
        AbstractProduct product = proxyStore.buy(tool);
        // check
        if ("null".equals(proxyStore.buy(tool).getName())
                && proxyStore.buy(tool) instanceof AbstractTool) {
            products.add(product);
            return (AbstractTool) product;
        } else {
            throw new NullPointerException("you can not get the tool");
        }
    }

    /**
     * storage produce
     * @param produce AbstractProduce
     */
    public void storage(AbstractProduce produce) {
        NormalBox normalBox = new NormalBox();
        normalBox.storage(produce);
    }

    @Override
    public void clean() {
        if (null != cleanable) {
            cleanable.clean();
        } else {
            System.out.println("you do not add clean way");
        }
    }

}
