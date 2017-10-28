package com.haveacupofjava.happyfarm.task;

public class RequestParsingRule {

    private String commandString;
    private RequestCategory requestCategory;
    private String tool;
    private Class field;

    public RequestParsingRule(String commandString,
                       RequestCategory requestCategory,
                       String tool,
                       Class field) {
        this.commandString = commandString;
        this.requestCategory = requestCategory;
        this.tool = tool;
        this.field = field;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

    public RequestCategory getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(RequestCategory requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public Class getField() {
        return field;
    }

    public void setField(Class field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof RequestParsingRule)
                && ((RequestParsingRule) obj).commandString.equals(commandString)
                && ((RequestParsingRule) obj).tool.equals(tool)
                && ((RequestParsingRule) obj).field.equals(field);
    }

}
