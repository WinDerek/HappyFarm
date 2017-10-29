package com.haveacupofjava.happyfarm.task;


import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.farmhand.AnimalFarmHand;
import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.AbstractPen;

import java.util.ArrayList;
import java.util.List;

/**
  * Class PenTask
  * Task about Pen, AnimalFarmHand
  */
public class PenTask extends AbstractTask {

    public AnimalFarmHand farmhand;
    public String tool;
    public List<AbstractPen> penList;

    public PenTask(AnimalFarmHand farmhand, String tool, Class penClazz) {
        this.farmhand = farmhand;
        this.tool = tool;

        List<AbstractField> fieldList = null;
        try {
            fieldList = HappyFarm.getInstance().getFieldList();
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }

        penList = new ArrayList<>();

        for (AbstractField field : fieldList) {
            if (field.getClass().getName().equalsIgnoreCase(penClazz.getName())) {
                penList.add((AbstractPen) field);
            }
        }
    }

    @Override
    public void execute(){
        farmhand.useTool(tool, penList);
    }

}
