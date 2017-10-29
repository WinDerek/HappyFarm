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

    /**
     * Let this farmhand use this tool
     * @param tool The tool to be used
     * @param fieldList The list of field that this tool have effect on
     */
    public void useTool(String tool, List<AbstractFarmland> fieldList){
        this.tool = getTool(tool);
        for(AbstractFarmland field : fieldList){
            this.tool.handleField(field);
        }
    }

}
