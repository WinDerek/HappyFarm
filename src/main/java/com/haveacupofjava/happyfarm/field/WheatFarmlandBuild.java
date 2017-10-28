package com.haveacupofjava.happyfarm.field;

public class WheatFarmlandBuild extends AbstractFieldBuilder<WheatFarmLand> {

    @Override
    public void buildDecorator() {
        new Fence(this.field);
        new Fence(this.field);
    }

    @Override
    public void buildField() {
        this.field = new WheatFarmLand();
    }
}
