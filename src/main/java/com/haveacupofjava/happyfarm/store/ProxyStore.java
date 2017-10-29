package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class ProxyStore extends AbstractStore {

    private FactoryStore factoryStore;

    private static ProxyStore proxyStore;

    private ProxyStore(){
        this.factoryStore = new FactoryStore();
    }

    /**
     *
     * @return instance of proxy store
     */
    public static ProxyStore getInstance(){
        if(null == proxyStore){
            proxyStore = new ProxyStore();
        }
        return proxyStore;
    }

    /**
     *
     * @param name product name
     * @return
     */
    @Override
    public AbstractProduct buy(String name) {
        return factoryStore.buy(name);
    }

    @Override
    public void show() {
        factoryStore.show();
    }

}
