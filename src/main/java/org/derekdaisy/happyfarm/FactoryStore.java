package org.derekdaisy.happyfarm;


import org.derekdaisy.happyfarm.field.AbstractGoods;

import java.util.HashMap;
import java.util.List;

/**
 * FactoryStore class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class FactoryStore extends AbstractStore {

    private HashMap<String, AbstractGoods> goods;
    private static List<String> goodsNames;

    // goods list, maybe read from config
    static {
        goodsNames.add("computer");
        goodsNames.add("cloth");
    }

    @Override
    public void buy(String goodsName) {
        if(null != goods.get(goodsName)){
            System.out.println(goodsName);
        }else {
            AbstractGoods produce = produce(goodsName);
            System.out.println(produce.name);
        }
    }

    /**
     * show the list of goods
     */
    public void show(){
        for(String name : goodsNames){
            System.out.println(name);
        }
    }

    /**
     * produce a new goods
     * @param goodsName
     * @return
     */
    private AbstractGoods produce(String goodsName){
        switch (goodsName) {
            case "computer":
                ComputerGoods computer = new ComputerGoods();
                goods.put("computer", computer);
                return computer;
            case "cloth":
                ClothGoods cloth = new ClothGoods();
                goods.put("cloth", cloth);
                return cloth;
            default:
                return new NullGoods();
        }
    }
}
