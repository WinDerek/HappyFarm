package com.haveacupofjava.happyfarm.task;

/**
  * Class AbstractTask
  * Task
  * @author Yiqun Lin
  */
public abstract class AbstractTask {

    /**
      * execute the command with null param
      * @param null
      * @return
      * @author Yiqun Lin
      */
    public abstract void execute();
    // object: farmhand, tool, field
    // function: useTool
    // farmhand.useTool(tool, field)
}
