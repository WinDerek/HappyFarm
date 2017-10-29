package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

public class NullToolProduct extends AbstractTool {

    public NullToolProduct() {
        setName("Not Available");
        setPrice(0D);
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

    @Override
    public void handleField(AbstractField filed) {
        // TODO: Improve the solution of null object
        System.out.println("This is a NULL Tool and cannot handle any fields");
    }

}
