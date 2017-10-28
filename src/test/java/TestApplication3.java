import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.produce.SheepMilk;
import com.haveacupofjava.happyfarm.product.*;
import com.haveacupofjava.happyfarm.room.BedRoom;
import com.haveacupofjava.happyfarm.room.BrushDecoratorRoom;
import com.haveacupofjava.happyfarm.room.Cleanable;
import com.haveacupofjava.happyfarm.room.Wipe;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.store.ProxyStore;

public class TestApplication3 {
    public static void main(String[] args) {
        // buy product from proxy store
        System.out.println("\n---------------farmer go shopping------------------");
        Farmer farmer = Farmer.getInstance();
        farmer.goShopping();
//        ProxyStore proxyStore = ProxyStore.getInstance();
//        proxyStore.show();
//        System.out.println("\n---------------------------------------------------");
//        Bed bed = (Bed) proxyStore.buy("bed");
//        System.out.println(bed.getName());
//        System.out.println("\n---------------------------------------------------");
//        // get hoe from storage
//        StorageRoom storageRoom = StorageRoom.getInstance();
//        // storageRoom.addProduct(hoe);
//        Hoe mHoe = (Hoe) storageRoom.getTool("hoe");
//        System.out.println(mHoe.getName());
//        System.out.println("\n----------------show items bedroom-----------------");
//        // show items bedroom
//        BedRoom bedRoom = new BedRoom();
//        bedRoom.show();
//        bedRoom.addProduct(bed);
//        System.out.println("\n------------------decorator room-------------------");
//        // decorator the room
//        BrushDecoratorRoom brushDecoratorRoom = new BrushDecoratorRoom(bedRoom);
//        brushDecoratorRoom.show();
        System.out.println("\n-------------------farmer build--------------------");
        farmer.buildRoom("livingroom", "livingroom");

        System.out.println("\n-------------------farmer clean--------------------");
        farmer.cleanRoom("livingroom", "wipe");

        System.out.println("\n------------------farmer decorator-----------------");
        farmer.decoratorRoom("livingroom", "brush");

        System.out.println("\n--------------------farmer buy---------------------");
        farmer.buyProduct("hoe", 1);

        System.out.println("\n--------------- farmer storage produce-------------");
        farmer.storageProduce(new SheepMilk());

        System.out.println("\n---------------- farmer get produce----------------");
        farmer.getProduce("milk");


    }
}
