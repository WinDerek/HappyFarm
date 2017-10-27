package com.haveacupofjava.happyfarm.field;

public class ConcreteFieldBuilder extends AbstractFieldBuilder{
    @Override
    public void buildDecorator() {
        System.out.println("build decorator");
        new ConcreteDecorator(this.field);
        new ConcreteDecorator(this.field);
        new ConcreteDecorator(this.field);
    }

    @Override
    public void buildField(){
        field = new ConcreteField();
        System.out.println("build field");
    }

    public void show(){
        System.out.println("concrete builder");
    }
}
