package com.haveacupofjava.happyfarm.product;

import com.haveacupofjava.happyfarm.field.AbstractField;

/**
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class NullToolProduct extends AbstractTool {


    public NullToolProduct() {
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
