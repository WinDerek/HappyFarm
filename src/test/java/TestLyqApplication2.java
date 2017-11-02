import com.haveacupofjava.happyfarm.field.WheatFarmland;
import com.haveacupofjava.happyfarm.task.*;

public class TestLyqApplication2 {
    public static void main(String[] args) {
        //farmer.releaseCommand(string)
        String cmd = "water wheat";

        try {
            RequestParsingRule rpr =
                    new RequestParsingRule(
                            "water wheat",
                            RequestCategory.FARM_REQUEST,
                            "wTool",
                            WheatFarmland.class
                    );
            Request.addRequestParsingRule(rpr);

            AnimalManagerHandler animalManagerHandler = new AnimalManagerHandler();
            PlantManagerHandler plantManagerHandler = new PlantManagerHandler();

            animalManagerHandler.setNext(plantManagerHandler);

            Request request = new Request(cmd);
            animalManagerHandler.handleRequest(request);
        } catch (RequestParsingException rpe) {
            System.out.println("Parsing Error: " + rpe);
        } catch (DuplicateRequestParsingRuleException drpe) {
            System.out.println("Add Parsing Rule Error: " + drpe);
        }
    }
}
