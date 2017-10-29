package com.haveacupofjava.happyfarm.field;

public class WheatFarmlandBuilder extends AbstractFieldBuilder<WheatFarmland> {

    @Override
    public void buildDecorator() {
        new Fence(this.field);
        new Fence(this.field);
    }

    @Override
    public void buildField() {
        this.field = new WheatFarmland();
    }

}
