package com.haveacupofjava.happyfarm.field;

/**
  * Class AbstractFieldBuilder
  * includes 2 functions to build a field
  * @author Yiqun Lin
  */
public abstract class AbstractFieldBuilder {
    protected AbstractField field;

    /**
      * create decorator
      * @param null
      * @return void
      * @author Yiqun Lin
      */
    public abstract void buildDecorator();

    /**
      * new field and initialize its attributes
      * @param null
      * @return void
      * @author Yiqun Lin
      */
    public abstract void buildField();

    /**
      * get product
      * @param null
      * @return AbstractField
      * @author Yiqun Lin
      */
    public AbstractField getField(){
        return field;
    }
}
