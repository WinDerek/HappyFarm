package com.haveacupofjava.happyfarm.product;

public class NullToolProduct extends AbstractTool {


    public NullToolProduct() {
        setName("Not Available");
    }

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public NullToolProduct clone() {
        NullToolProduct nullProduct = new NullToolProduct();
        nullProduct.setName(this.getName());
        return nullProduct;
    }
}
