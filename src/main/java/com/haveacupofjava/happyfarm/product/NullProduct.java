package com.haveacupofjava.happyfarm.product;

public class NullProduct extends AbstractProduct {


    public NullProduct() {
        setName("Not Available");
        setPrice(0D);
    }

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public NullProduct clone() {
        NullProduct nullProduct = new NullProduct();
        nullProduct.setName(this.getName());
        return nullProduct;
    }

}
