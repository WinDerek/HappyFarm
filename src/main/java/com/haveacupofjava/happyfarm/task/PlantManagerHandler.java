package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.farmhand.PlantFarmHand;

public class PlantManagerHandler extends AbstractManagerHandler {

    @Override
    protected RequestCategory getRequestCategory() {
        return RequestCategory.FARM_REQUEST;
    }

    @Override
    protected void handle(Request request) {
        String tool = request.getTool();
        Class clazz = request.getField();

        FarmlandTask task = new FarmlandTask(new PlantFarmHand(), tool, clazz);
        Invoker invoker = Invoker.getInstence();
        invoker.pushTask(task);

        System.out.println("Plant Manager has handled this request.");
    }

}
