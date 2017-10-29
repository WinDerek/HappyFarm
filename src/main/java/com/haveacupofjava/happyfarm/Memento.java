package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.room.AbstractRoom;

import java.util.List;
import java.util.Stack;

/**
  * Class Memento
  * default, only for package
  */
public class Memento {

    private static Stack<Memento> mementosStack = new Stack<Memento>();

    public static void addState(Memento memento){
        mementosStack.add(memento);
    }

    public static Memento popState(){
        return mementosStack.pop();
    }

    /**
      * state
      */
    private Double funds;
    private List<AbstractField> fieldList;
    private List<AbstractRoom> roomList;
    private List<AbstractProduct> productsList;

    void setState(Double funds, List<AbstractField> fieldList,
                  List<AbstractRoom> roomList,
                  List<AbstractProduct> productsList)
            throws MementoSettingException {
        if ((funds != null)
                && (fieldList != null)
                && (roomList!= null)
                && (productsList != null)) {
            this.funds = funds;
            this.fieldList = fieldList;
            this.roomList = roomList;
            this.productsList = productsList;
        } else {
            throw new MementoSettingException("Parameters mustn't be null.");
        }
    }

    Double getFunds(){
        return this.funds;
    }

    List<AbstractField> getFieldList() {
        return fieldList;
    }

    List<AbstractRoom> getRoomList() {
        return roomList;
    }

    List<AbstractProduct> getProductsList(){
        return productsList;
    }

}
