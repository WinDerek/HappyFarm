package com.haveacupofjava.happyfarm.field;

public class ConcreteDecorator extends AbstractFieldDecorator{

    @Override
    public void show(){
        System.out.println("concrete decorator");
        this.component.show();
    }

    public ConcreteDecorator(AbstractField field){
        decorateFiled(field);
    }
}
