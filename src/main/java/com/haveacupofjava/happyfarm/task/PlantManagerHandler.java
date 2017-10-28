package com.haveacupofjava.happyfarm.task;

public class PlantManagerHandler extends AbstractManagerHandler{
    @Override
    protected RequestCategory getRequestCategory(){
        return RequestCategory.FARM_REQUEST;
    }

    @Override
    protected void handle(Request request){
        String tool = request.getTool();
        Class clazz = request.getField();
        // TODO
        // create a Task to Invoker
        System.out.println("Plant Manager has handled this request.");
    }
}
