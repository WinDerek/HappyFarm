package org.derekdaisy.happyfarm;

import org.derekdaisy.happyfarm.task.Command;

import java.util.List;

public abstract class Person {

    private String name;

    private List<Command> commandList;

    public Person() {}

    public Person(String name, List<Command> commandList) {
        this.name = name;
        this.commandList = commandList;
    }

    public String getNam() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

}
