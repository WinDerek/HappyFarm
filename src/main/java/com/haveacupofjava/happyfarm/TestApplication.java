package com.haveacupofjava.happyfarm;

import com.haveacupofjava.happyfarm.product.*;
import com.haveacupofjava.happyfarm.room.BedRoom;
import com.haveacupofjava.happyfarm.room.BrushDecoratorRoom;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.store.ProxyStore;

public class TestApplication {
    public static void main(String[] args) {
        // buy product from proxy store
        System.out.println("---------------------------------------------------");
        ProxyStore proxyStore = ProxyStore.getInstance();
        proxyStore.show();
        System.out.println("---------------------------------------------------");
        Bed bed = (Bed) proxyStore.buy("bed");
        System.out.println(bed.getName());
        System.out.println("---------------------------------------------------");
        // get hoe from storage
        StorageRoom storageRoom = StorageRoom.getInstance();
        // storageRoom.addProduct(hoe);
        Hoe mHoe = (Hoe) storageRoom.getTool("hoe");
        System.out.println(mHoe.getName());
        System.out.println("---------------------------------------------------");
        // show items bedroom
        BedRoom bedRoom = new BedRoom();
        bedRoom.show();
        bedRoom.addProduct(bed);
        System.out.println("---------------------------------------------------");
        // decorator the room
        BrushDecoratorRoom brushDecoratorRoom = new BrushDecoratorRoom(bedRoom);
        brushDecoratorRoom.show();
        System.out.println("---------------------------------------------------");
        // storage produce
        //Hoe hoe = (Hoe) storageRoom.getTool("hoe");
//        System.out.println(hoe.getName());

    }
}
