package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.field.AbstractFarmland;

import java.util.List;

public class PlantFarmHand extends AbstractFarmHand {

    /**
      * farmhand use tool to handle farm field command
      * @param null
      * @return
      * @author Yiqun Lin
      */
    public void useTool(String tool, List<AbstractFarmland> fieldList){
        this.tool = getTool(tool);
        for(AbstractFarmland field : fieldList){
            this.tool.handleField(field);
        }
    }
}
