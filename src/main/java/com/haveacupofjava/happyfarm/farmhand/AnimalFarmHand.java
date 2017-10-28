package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.field.AbstractPen;

import java.util.List;

public class AnimalFarmHand extends AbstractFarmHand {

    /**
      * farmhand use tool to handle pen field command
      * @param null
      * @return
      * @author Yiqun Lin
      */
    public void useTool(String tool, List<AbstractPen> fieldList) {
        this.tool = getTool(tool);
        for (AbstractPen field : fieldList) {
            this.tool.handleField(field);
        }
    }
}
