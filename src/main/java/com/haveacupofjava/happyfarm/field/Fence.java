package com.haveacupofjava.happyfarm.field;

public class Fence extends AbstractFieldDecorator {

    public Fence(AbstractField field) {
        super(field);
    }

    @Override
    public void show() {
        System.out.println("a fence decorator");
        this.component.show();
    }

}
