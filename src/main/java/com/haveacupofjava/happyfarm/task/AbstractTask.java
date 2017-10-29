package com.haveacupofjava.happyfarm.task;

import java.io.Serializable;

/**
  * Class AbstractTask
  * Task
  */
public abstract class AbstractTask implements Serializable {

    /**
      * execute the command with null param
      */
    public abstract void execute();

}
