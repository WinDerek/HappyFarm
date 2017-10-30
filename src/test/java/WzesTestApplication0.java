import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.produce.SheepMilk;

/**
 * Test Application
 * @author Create by xuantang
 * @date on 10/29/17
 */
public class WzesTestApplication0 {
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
//        // get hoe from store
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

        System.out.println("\n----------------farmer wrong clean------------------");
        farmer.cleanRoom("livingroom", "wipee");

        System.out.println("\n-------------------farmer clean--------------------");
        farmer.cleanRoom("livingroom", "wipe");

        System.out.println("\n------------------farmer decorator-----------------");
        farmer.decorateRoom("livingroom", "brush");

        System.out.println("\n--------------------farmer buy---------------------");
        farmer.buyProduct("hoe", 1);

        // The reason to comment this lines of code: The client is not allowed to store produces into the storage room
//        System.out.println("\n--------------- farmer store produce-------------");
//        farmer.storeProduce(new SheepMilk());
//        System.out.println("\n--------------- farmer store produce-------------");
//        farmer.storeProduce(new SheepMilk());
//        System.out.println("\n---------------- farmer get produce----------------");
//        farmer.getProduce(SheepMilk.class, 1);
//        System.out.println("\n-------------- farmer get more produce-------------");
//        farmer.getProduce(SheepMilk.class, 1);

    }
}
