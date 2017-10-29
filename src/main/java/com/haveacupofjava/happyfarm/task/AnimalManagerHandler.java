package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.farmhand.AnimalFarmHand;

public class AnimalManagerHandler extends AbstractManagerHandler {

    @Override
    protected RequestCategory getRequestCategory() {
        return RequestCategory.PEN_REQUEST;
    }

    @Override
    protected void handle(Request request) {
        String tool = request.getTool();
        Class clazz = request.getField();

        PenTask task = new PenTask(new AnimalFarmHand(), tool, clazz);
        Invoker invoker = Invoker.getInstence();
        invoker.pushTask(task);

        System.out.println("Animal Manager has handled this request.");
    }

}
