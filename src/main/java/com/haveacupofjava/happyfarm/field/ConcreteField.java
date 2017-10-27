package com.haveacupofjava.happyfarm.field;

public class ConcreteField extends AbstractPen{

    @Override
    public void showField(){
        this.decorator.show();
        System.out.println("show function finished");
    }

    @Override
    public void show(){
        System.out.println("concrete field");
    }
}
