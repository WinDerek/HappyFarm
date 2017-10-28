package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.farmhand.AnimalFarmHand;
import com.haveacupofjava.happyfarm.farmhand.PlantFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractFarmland;

import java.util.ArrayList;
import java.util.List;

/**
  * Class FarmlandTask
  * Task about Farm, PlantFarmHand
  * @author Yiqun Lin
  */
public class FarmlandTask extends AbstractTask{
    public PlantFarmHand farmhand;
    public String tool;
    public List<AbstractFarmland> farmlandList;
    // TODO
    // need a function object

    public FarmlandTask(PlantFarmHand farmhand, String tool, Class penClazz){
        this.farmhand = farmhand;
        this.tool = tool;

        // TODO
        // search from HappyFarm, and get the list of farm fields to handle
        farmlandList = new ArrayList<>();
    }

    @Override
    public void execute(){
        farmhand.useTool(tool, farmlandList);
    }

}
