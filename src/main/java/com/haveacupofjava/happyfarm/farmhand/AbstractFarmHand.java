package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;

public abstract class AbstractFarmHand {

    protected AbstractTool tool;

    /**
     * Gets a tool
     * @param tool The name of the tool to get
     * @return The corresponsing tool
     */
    public AbstractTool getTool(String tool) {
        StorageRoom storageRoom = StorageRoom.getInstance();
        return storageRoom.getTool(tool);
    }

}
