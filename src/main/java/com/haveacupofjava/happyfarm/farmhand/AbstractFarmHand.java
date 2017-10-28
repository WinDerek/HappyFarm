package com.haveacupofjava.happyfarm.farmhand;

import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;

public abstract class AbstractFarmHand {

    protected AbstractTool tool;

    /**
     * get one tool
     * @param tool
     * @return
     */
    public AbstractTool getTool(String tool) {
        StorageRoom storageRoom = StorageRoom.getInstance();
        return storageRoom.getTool(tool);
    }

}
