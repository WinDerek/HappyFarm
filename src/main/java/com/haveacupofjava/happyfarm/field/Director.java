package com.haveacupofjava.happyfarm.field;

/**
  * Class Director
  * Description
  */
public class Director {
    private AbstractFieldBuilder builder;

    public Director(AbstractFieldBuilder builder){
        this.builder = builder;
    }

    public void constructField() {
        builder.buildField();
        builder.buildDecorator();
    }

}
