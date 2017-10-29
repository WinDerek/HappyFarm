package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.field.AbstractPen;

import java.util.List;

public class AnimalFarmHand extends AbstractFarmHand {

    /**
     * Let this farmhand use the tool
     * @param tool The tool to be used
     * @param fieldList The list of field that this tool effect on
     */
    public void useTool(String tool, List<AbstractPen> fieldList) {
        this.tool = getTool(tool);
        for (AbstractPen field : fieldList) {
            this.tool.handleField(field);
        }
    }

}
