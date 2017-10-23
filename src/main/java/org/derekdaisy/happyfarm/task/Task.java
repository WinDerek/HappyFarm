package org.derekdaisy.happyfarm.task;

public abstract class Task implements Command {

    private Object receiver;

    public Task() {}

    public Task(Object receiver) {
        this.receiver = receiver;
    }

    public Object getReceiver() {
        return receiver;
    }

    public void setEffector(Object receiver) {
        this.receiver = receiver;
    }

    public void execute() {}

}
