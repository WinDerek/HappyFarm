package com.haveacupofjava.happyfarm.field;

public class SheepPenBuilder extends AbstractFieldBuilder<SheepPen> {
    @Override
    public void buildDecorator() {
        new Fence(this.field);
        new Fence(this.field);
    }

    @Override
    public void buildField() {
        this.field = new SheepPen();
    }
}
