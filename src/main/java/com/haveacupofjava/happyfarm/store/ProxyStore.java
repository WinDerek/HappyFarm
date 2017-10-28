package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class ProxyStore extends AbstractStore {

    private FactoryStore factoryStore;

    private static ProxyStore proxyStore;

    private ProxyStore(){
        this.factoryStore = new FactoryStore();
    }

    public static ProxyStore getInstance(){
        if(null == proxyStore){
            proxyStore = new ProxyStore();
        }
        return proxyStore;
    }

    @Override
    public AbstractProduct buy(String name) {
        return factoryStore.buy(name);
    }

    @Override
    public void show() {
        factoryStore.show();
    }

}
