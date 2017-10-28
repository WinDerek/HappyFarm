package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.visitor.AbstractFieldVisitor;

/**
  * Class AbstractField
  * Abstract Field
  * @author Yiqun Lin
  */
public abstract class AbstractField extends AbstractFieldComponent {

    protected AbstractFieldDecorator decorator;

    // TODO
    /*
     * a container for creature
     */
    public void resetDecoratorHead(AbstractFieldDecorator decorator) {
        this.decorator = decorator;
    }

    public AbstractFieldComponent getDecoratorHead() {
        if (this.decorator == null) {
            return this;
        }

        return this.decorator;
    }

    public void showField() {
        this.decorator.show();
    }

    @Override
    public abstract void show();

    /**
     * Accepts the visitor
     * @param visitor The visitor
     */
    public abstract void acceptVisitor(AbstractFieldVisitor visitor);

}
