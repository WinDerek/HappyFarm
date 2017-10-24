package org.derekdaisy.happyfarm;


/**
 * ProxyStore class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class ProxyStore extends AbstractStore {

    private FactoryStore factoryStore;

    public ProxyStore(){
        this.factoryStore = new FactoryStore();
    }

    @Override
    public void buy(String goodsName) {
        factoryStore.buy(goodsName);
    }

    public void show(){
        factoryStore.show();
    }
}
