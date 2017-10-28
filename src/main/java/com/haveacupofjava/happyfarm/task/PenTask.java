package com.haveacupofjava.happyfarm.task;


import com.haveacupofjava.happyfarm.farmhand.AnimalFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractPen;

/**
  * Class PenTask
  * Task about Pen, AnimalFarmHand
  * @author Yiqun Lin
  */
public class PenTask extends AbstractTask{
    public AnimalFarmHand farmhand;
    public String tool;
    public AbstractPen pen;
    // TODO
    // need a function object

    @Override
    public void execute(){
        farmhand.useTool(tool, pen);
    }
}
