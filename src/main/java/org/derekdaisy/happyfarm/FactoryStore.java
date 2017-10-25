package org.derekdaisy.happyfarm;


import org.derekdaisy.happyfarm.field.Product;

import java.util.HashMap;
import java.util.List;

import static org.derekdaisy.happyfarm.field.Product.CLOTHES_PRODUCT;
import static org.derekdaisy.happyfarm.field.Product.COMPUTER_PRODUCT;

/**
 * FactoryStore class
 *
 * @author ${USER}
 * @date 2017/10/24
 */
public class FactoryStore extends AbstractStore {

    private HashMap<String, Product> products;
    private static List<String> productNames;
   

    // products list, maybe read from config
    static {
        productNames.add(COMPUTER_PRODUCT);
        productNames.add(CLOTHES_PRODUCT);
    }

    @Override
    public void buy(String productName) {
        if(null != products.get(productName)){
            System.out.println(productName);
        }else {
            Product produce = produce(productName);
            System.out.println(produce.name);
        }
    }

    /**
     * show the list of products
     */
    public void show(){
        for(String productName : productNames){
            System.out.println(productName);
        }
    }

    /**
     * produce a new products
     * @param productName
     * @return
     */
    private Product produce(String productName){
        switch (productName) {
            case COMPUTER_PRODUCT:
                ComputerProduct computer = new ComputerProduct();
                products.put(COMPUTER_PRODUCT, computer);
                return computer;
            case CLOTHES_PRODUCT:
                ClothesProduct clothes = new ClothesProduct();
                products.put(CLOTHES_PRODUCT, clothes);
                return clothes;
            default:
                return new NullProduct();
        }
    }
}
