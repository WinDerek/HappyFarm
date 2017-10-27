package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.farmhand.PlantFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractFarmLand;

/**
  * Class FarmTask
  * Task about Farm, PlantFarmHand
  * @author Yiqun Lin
  */
public class FarmTask extends AbstractTask{
    public PlantFarmHand farmhand;
    public String tool;
    public AbstractFarmLand farmland;
    // TODO
    // need a function object

    @Override
    public void execute(){
        farmhand.useTool(tool, farmland);
    }
}
