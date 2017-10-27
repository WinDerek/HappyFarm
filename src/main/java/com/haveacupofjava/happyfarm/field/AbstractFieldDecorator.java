package com.haveacupofjava.happyfarm.field;

/**
  * Class AbstractFieldDecorator
  * decorator to decorate field
  * @author Yiqun Lin
  */
public abstract class AbstractFieldDecorator extends AbstractFieldComponent{
    public AbstractFieldComponent component;

    public AbstractFieldDecorator(){}

    /**
      * Description
      * @param AbstractField
      * @author Yiqun Lin
      */
    public AbstractFieldDecorator(AbstractField field){
        decorateFiled(field);
    }

    /**
      * decorate the field
      * @param null
      * @return void
      * @author Yiqun Lin
      */
    protected void decorateFiled(AbstractField field){
        this.component = field.getDecoratorHead();
        field.resetDecoratorHead(this);
    }

}
