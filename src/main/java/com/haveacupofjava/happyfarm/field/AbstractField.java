package com.haveacupofjava.happyfarm.field;

/**
  * Class AbstractField
  * Abstract Field
  * @author Yiqun Lin
  */
public abstract class AbstractField extends AbstractFieldComponent{
    protected AbstractFieldDecorator decorator;

    public void resetDecoratorHead(AbstractFieldDecorator decorator){
        this.decorator = decorator;
    }

    public AbstractFieldComponent getDecoratorHead(){
        if(this.decorator == null){
            return this;
        }
        return this.decorator;
    }

    public void showField(){

    }

    @Override
    public abstract void show();
}
