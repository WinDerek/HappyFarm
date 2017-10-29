package com.haveacupofjava.happyfarm.field;

public class PigPenBuilder extends AbstractFieldBuilder<PigPen> {

    @Override
    public void buildField() {
        field = new PigPen();
    }

    @Override
    public void buildDecorator() {
        new Fence(this.field);
        new Fence(this.field);
    }

}
