package com.haveacupofjava.happyfarm.field;

public class HenPenBuilder extends AbstractFieldBuilder<HenPen> {

    @Override
    public void buildDecorator() {
        new Fence(this.field);
    }

    @Override
    public void buildField() {
        this.field = new HenPen();
    }
}
