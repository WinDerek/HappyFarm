package com.haveacupofjava.happyfarm.farmhand;


import com.haveacupofjava.happyfarm.field.AbstractFarmLand;

public class PlantFarmHand extends AbstractFarmHand {

    /**
     * farmhand use tool to handle farm field command
     * @param null
     * @return
     * @author Yiqun Lin
     */
    public void useTool(String tool, AbstractFarmLand field){
        this.tool = getTool(tool);
        this.tool.handleField(field);
    }
}
