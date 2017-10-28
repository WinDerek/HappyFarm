package com.haveacupofjava.happyfarm.task;


import com.haveacupofjava.happyfarm.farmhand.AnimalFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractPen;

import java.util.List;

/**
  * Class PenTask
  * Task about Pen, AnimalFarmHand
  * @author Yiqun Lin
  */
public class PenTask extends AbstractTask{
    public AnimalFarmHand farmhand;
    public String tool;
    public List<AbstractPen> penList;

    // TODO
    // need a function object

    public PenTask(AnimalFarmHand farmhand, String tool, Class penClazz){
        this.farmhand = farmhand;
        this.tool = tool;

        // TODO
        // search from HappyFarm, and get the list of pen fields to handle
    }

    @Override
    public void execute(){
        farmhand.useTool(tool, penList);
    }
}
