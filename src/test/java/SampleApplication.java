import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.field.PigPen;
import com.haveacupofjava.happyfarm.field.PigPenBuilder;
import com.haveacupofjava.happyfarm.produce.PigMilk;
import com.haveacupofjava.happyfarm.store.FactoryStore;
import com.haveacupofjava.happyfarm.task.Request;
import com.haveacupofjava.happyfarm.task.RequestCategory;
import com.haveacupofjava.happyfarm.task.RequestParsingRule;

public class SampleApplication {

    public static void main(String[] args) throws Exception {
        Farmer farmer = Farmer.getInstance();
        HappyFarm happyFarm = HappyFarm.getInstance();

        happyFarm.save();

        farmer.buyField(new PigPenBuilder());
        farmer.buyField(new PigPenBuilder());
        farmer.buyAnimal(new PigFactory(), 2);

        Request.addRequestParsingRule(
                new RequestParsingRule(
                        "Stimulate all the pigs to produce!",
                        RequestCategory.PEN_REQUEST,
                        PigProductionStimulator.class.getSimpleName(),
                        PigPen.class
                )
        );

        Request.addRequestParsingRule(
                new RequestParsingRule(
                        "Please collect pig milk",
                        RequestCategory.PEN_REQUEST,
                        Bucket.class.getSimpleName(),
                        PigPen.class)
        );

        FactoryStore.addTool(Bucket.class.getSimpleName(), new Bucket());
        FactoryStore.addTool(PigProductionStimulator.class.getSimpleName(),
                new PigProductionStimulator());

        Request stimulatePigProductionRequest =
                new Request("Stimulate all the pigs to produce!");
        Request collectPigMilkRequest = new Request("Please collect pig milk");

        farmer.handleRequest(stimulatePigProductionRequest);
        farmer.handleRequest(collectPigMilkRequest);

        System.out.println("The funds of HappyFarm before trade: " + happyFarm.getFunds());

        while (farmer.sellProduce(PigMilk.class, 1)) {}

        System.out.println("The funds of HappyFarm after trade: " + happyFarm.getFunds());

        happyFarm.showFieldsInformation();

        happyFarm.reload();

        System.out.println("The funds of HappyFarm after reload: " + happyFarm.getFunds());
    }

}
