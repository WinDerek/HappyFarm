package com.haveacupofjava.happyfarm.store;

import com.haveacupofjava.happyfarm.product.AbstractProduct;

public class ProxyStore extends AbstractStore {

    private FactoryStore factoryStore;

    public ProxyStore(){
        this.factoryStore = new FactoryStore();
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
