package com.haveacupofjava.happyfarm.field;

/**
  * Class Director
  * Description
  * @author Yiqun Lin
  */
public class Director {
    private AbstractFieldBuilder builder;

    /**
      * set field builder
      * @param null
      * @return
      * @author Yiqun Lin
      */
    public Director(AbstractFieldBuilder builder){
        this.builder = builder;
    }

    public void constructField(){
        builder.buildField();
        builder.buildDecorator();
    }

}
