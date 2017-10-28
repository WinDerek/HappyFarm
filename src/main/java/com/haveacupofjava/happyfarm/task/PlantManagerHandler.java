package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.farmhand.PlantFarmHand;

public class PlantManagerHandler extends AbstractManagerHandler{
    @Override
    protected RequestCategory getRequestCategory(){
        return RequestCategory.FARM_REQUEST;
    }

    @Override
    protected void handle(Request request){
        String tool = request.getTool();
        Class clazz = request.getField();

        FarmTask task = new FarmTask(new PlantFarmHand(), tool, clazz);
        Invoker invoker = Invoker.getInstence();
        invoker.pushTask(task);

        System.out.println("Plant Manager has handled this request.");
    }
}
