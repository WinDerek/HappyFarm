package com.haveacupofjava.happyfarm.field;

/**
  * Class AbstractFieldBuilder
  * includes 2 functions to build a field
  */
public abstract class AbstractFieldBuilder<T extends AbstractField> {

    protected T field;

    public abstract void buildDecorator();

    public abstract void buildField();

    public T getField(){
        return field;
    }

}
