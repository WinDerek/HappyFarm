package org.derekdaisy.happyfarm;


/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class ProxyStore extends Store {

    private FactoryStore factoryStore;

    public ProxyStore(){
        this.factoryStore = new FactoryStore();
    }

    @Override
    public void buy(String goods_name) {
        factoryStore.buy(goods_name);
    }

    public void show(){
        factoryStore.show();
    }
}
