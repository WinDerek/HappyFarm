package org.derekdaisy.happyfarm.task;

import org.derekdaisy.happyfarm.Person;

public abstract class Task {

    private Person actor;
    private Object effector;
    private Command command;

    public Task() {}

    public Task(Person actor, Object effector, Command command) {
        this.actor = actor;
        this.effector = effector;
        this.command = command;
    }

    public Object getActor() {
        return actor;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }

    public Object getEffector() {
        return effector;
    }

    public void setEffector(Object effector) {
        this.effector = effector;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
