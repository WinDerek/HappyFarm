package com.haveacupofjava.happyfarm.product;

public class NullProduct extends AbstractProduct {


    public NullProduct() {
        setName("null");
    }

    @Override
    public NullProduct clone() {
        NullProduct nullProduct = new NullProduct();
        nullProduct.setName(this.getName());
        return nullProduct;
    }
}
