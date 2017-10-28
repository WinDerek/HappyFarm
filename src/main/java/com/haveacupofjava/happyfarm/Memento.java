package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.room.AbstractRoom;

import java.util.List;
import java.util.Stack;

/**
  * Class Memento
  * default, only for package
  * @author Yiqun Lin
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
      * @author Yiqun Lin
      */
    private Double funds;
    private List<AbstractField> fieldList;
    private List<AbstractRoom> roomList;

    void setState(Double funds, List<AbstractField> fieldList, List<AbstractRoom> roomList) throws MementoSettingException{
        if(funds != null && fieldList != null && roomList!= null ) {
            this.funds = funds;
            this.fieldList = fieldList;
            this.roomList = roomList;
        }else{
            throw new MementoSettingException("Parameters should not be a null.");
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
}
