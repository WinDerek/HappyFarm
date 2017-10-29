package com.haveacupofjava.happyfarm.task;

import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.farmhand.PlantFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractFarmland;
import com.haveacupofjava.happyfarm.field.AbstractField;

import java.util.ArrayList;
import java.util.List;

/**
  * Class FarmlandTask
  * Task about Farm, PlantFarmHand
  */
public class FarmlandTask extends AbstractTask {

    public PlantFarmHand farmhand;
    public String tool;
    public List<AbstractFarmland> farmlandList;

    public FarmlandTask(PlantFarmHand farmhand, String tool, Class farmlandClazz) {
        this.farmhand = farmhand;
        this.tool = tool;

        // TODO Fixed. need a testing application
        // search from HappyFarm, and get the list of farm fields to handle

        List<AbstractField> fieldList = null;
        try {
            fieldList = HappyFarm.getInstance().getFieldList();
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }

        farmlandList = new ArrayList<>();

        for (AbstractField field : fieldList) {
            if (field.getClass().getName().equalsIgnoreCase(farmlandClazz.getName())) {
                farmlandList.add((AbstractFarmland) field);
            }
        }
    }

    @Override
    public void execute(){
        farmhand.useTool(tool, farmlandList);
    }

}
