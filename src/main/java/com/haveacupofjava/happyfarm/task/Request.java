package com.haveacupofjava.happyfarm.task;

public class Request{
    private String command;

    private RequestCategory category;
    private String tool;
    private Class field;

    public Request(String command){
        this.command = command;
    }

    // TODO
    // get req from Parser

    public RequestCategory getCategory(){
        return category;
    }

    public String getToolName(){
        return tool;
    }

    public Class getFieldClass(){
        return field;
    }
}
