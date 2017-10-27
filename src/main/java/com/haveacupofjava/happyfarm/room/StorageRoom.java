package com.haveacupofjava.happyfarm.room;

import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.store.ProxyStore;

public class StorageRoom extends AbstractRoom {

    /**
     * return tool object
     * @param tool name
     * @return Tool
     */
    public AbstractTool getTool(String tool){
        // get tool from storage
        for(AbstractProduct product : products){
            if(product instanceof AbstractTool && product.name.equals(tool)){
                return (AbstractTool) product;
            }
        }
        // there is no tool int the storage room and buy it from proxy store
        ProxyStore proxyStore = new ProxyStore();
        AbstractProduct product = proxyStore.buy(tool);
        // check
        if("null".equals(proxyStore.buy(tool).name)
                && proxyStore.buy(tool) instanceof AbstractTool){
            products.add(product);
            return (AbstractTool) product;
        }else{
            throw new NullPointerException("you can not get the tool");
        }
    }


    public void storage(String name){
        NormalBox normalBox = new NormalBox();
        normalBox.storage(name);
    }

    @Override
    public void clean() {
        if(null != cleanable){
            cleanable.clean();
        }else{
            System.out.println("you do not add clean way");
        }

    }

}
