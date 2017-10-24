package org.derekdaisy.happyfarm;


import org.derekdaisy.happyfarm.field.Goods;

import java.util.HashMap;
import java.util.List;

/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public class FactoryStore extends Store{

    private HashMap<String, Goods> goods;
    private static List<String> goods_names;

    // goods list, maybe read from config
    static {
        goods_names.add("computer");
        goods_names.add("cloth");
    }

    @Override
    public void buy(String goods_name) {
        if(null != goods.get(goods_name)){
            System.out.println(goods_name);
        }else {
            Goods produce = produce(goods_name);
            System.out.println(produce.name);
        }
    }

    /**
     * show the list of goods
     */
    public void show(){
        for(String name : goods_names){
            System.out.println(name);
        }
    }

    /**
     * produce a new goods
     * @param goods_name
     * @return
     */
    private Goods produce(String goods_name){
        switch (goods_name) {
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
