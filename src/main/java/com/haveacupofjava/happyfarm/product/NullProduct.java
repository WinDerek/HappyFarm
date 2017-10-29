package com.haveacupofjava.happyfarm.product;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class NullProduct extends AbstractProduct {


    public NullProduct() {
        setName("Not Available");
        setPrice(0D);
    }

    /**
     * Check whether the object is empty
     * @return true
     */
    @Override
    public boolean isNil() {
        return true;
    }

    /**
     * Clone the nullProduct
     * @return nullProduct
     */
    @Override
    public NullProduct clone() {
        NullProduct nullProduct = new NullProduct();
        nullProduct.setName(this.getName());
        return nullProduct;
    }
}
