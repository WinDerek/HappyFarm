package com.haveacupofjava.happyfarm.field;

/**
  * Class AbstractFieldDecorator
  * decorator to decorate field
  * @author Yiqun Lin
  */
public abstract class AbstractFieldDecorator extends AbstractFieldComponent {

    public AbstractFieldComponent component;

    public AbstractFieldDecorator() {}

    public AbstractFieldDecorator(AbstractField field) {
        decorateFiled(field);
    }

    protected void decorateFiled(AbstractField field) {
        this.component = field.getDecoratorHead();
        field.resetDecoratorHead(this);
    }

}
