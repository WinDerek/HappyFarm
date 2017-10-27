package com.haveacupofjava.happyfarm.product;

public class NullProduct extends AbstractProduct {


    public NullProduct() {
        this.name = "null";
    }

    @Override
    public NullProduct clone() {
        NullProduct nullProduct = new NullProduct();
        nullProduct.name = this.name;
        return nullProduct;
    }
}
