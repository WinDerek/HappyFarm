package com.haveacupofjava.happyfarm.task;

import java.util.Stack;

public class Invoker {

    private static Invoker invoker;

    Stack<AbstractTask> taskStack;

    private Invoker(){
        taskStack = new Stack<>();
    }

    public static Invoker getInstence(){
        if(invoker == null) {
            invoker = new Invoker();
        }

        return invoker;
    }

    public void pushTask(AbstractTask task) {
        this.taskStack.add(task);
        System.out.println("Push task and execute immediately.");
        task.execute();//client should overwrite this function
    }

}
