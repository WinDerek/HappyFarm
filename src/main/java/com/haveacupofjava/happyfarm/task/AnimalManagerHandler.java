package com.haveacupofjava.happyfarm.task;

public class AnimalManagerHandler extends AbstractManagerHandler{
    @Override
    protected RequestCategory getRequestCategory(){
        return RequestCategory.PEN_REQUEST;
    }

    @Override
    protected void handle(Request request){
        String tool = request.getToolName();
        Class clazz = request.getFieldClass();
        // TODO
        // create a Task to Invoker
        System.out.println("Animal Manager has handled this request.");
    }
}
