package com.haveacupofjava.happyfarm.task;

public class AnimalManagerHandler extends AbstractManagerHandler{
    @Override
    protected RequestCategory getRequestCategory(){
        return RequestCategory.PEN_REQUEST;
    }

    @Override
    protected void handle(Request request){
        String tool = request.getTool();
        Class clazz = request.getField();
        // TODO
        // create a Task to Invoker
        System.out.println("Animal Manager has handled this request.");
    }
}
