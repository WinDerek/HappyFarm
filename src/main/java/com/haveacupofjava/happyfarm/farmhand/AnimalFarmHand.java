package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.field.AbstractPen;

public class AnimalFarmHand extends AbstractFarmHand {

    /**
      * farmhand use tool to handle pen field command
      * @param null
      * @return
      * @author Yiqun Lin
      */
    public void useTool(String tool, AbstractPen field){
        this.tool = getTool(tool);
        this.tool.handleField(field);
    }
}
