import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.factory.WheatFactory;
import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.AbstractPen;
import com.haveacupofjava.happyfarm.field.PigPen;
import com.haveacupofjava.happyfarm.field.PigPenBuilder;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.produce.PigMilk;
import com.haveacupofjava.happyfarm.product.AbstractTool;
import com.haveacupofjava.happyfarm.room.storage.StorageRoom;
import com.haveacupofjava.happyfarm.store.FactoryStore;
import com.haveacupofjava.happyfarm.store.ProxyStore;
import com.haveacupofjava.happyfarm.task.Request;
import com.haveacupofjava.happyfarm.task.RequestCategory;
import com.haveacupofjava.happyfarm.task.RequestParsingRule;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
//        Farmer farmer = Farmer.getInstance();
//        WheatFactory factory = new WheatFactory();
//        Wheat wheat = (Wheat)factory.getPlant();
//        wheat.addObserver(farmer);
//        wheat.produce();
//        PigFactory pigFactory = new PigFactory();
//        Pig pig = (Pig)pigFactory.getAnimal();
//        pig.addObserver(farmer);
//        pig.produce();

        Farmer.getInstance().buyField(new PigPenBuilder());
        Farmer.getInstance().buyAnimal(new PigFactory(), 2);

        RequestParsingRule requestParsingRule =
                new RequestParsingRule("Please collect pig milk",
                        RequestCategory.PEN_REQUEST,
                        "bucket",
                        PigPen.class);
        Request.addRequestParsingRule(requestParsingRule);

        FactoryStore.addTool("bucket", new Bucket());

        Request request = new Request("Please collect pig milk");

        Farmer.getInstance().handleRequest(request);

        Farmer.getInstance().sellProduce(PigMilk.class, 1);
    }

}
