import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.creature.Sheep;
import com.haveacupofjava.happyfarm.field.PigPen;
import com.haveacupofjava.happyfarm.security.MethodExposedException;
import com.haveacupofjava.happyfarm.task.Request;

public class TestApplication1 {

    public static void main(String[] args) {
        Farmer farmer = Farmer.getInstance();
        HappyFarm happyFarm = HappyFarm.getInstance();
        happyFarm.showFieldsInformation();
        PigPen pigPen = new PigPen();
        Sheep sheep = new Sheep();
        //pigPen.addAnimal(sheep);
        pigPen.feedAnimals();
        try {
            sheep.feed();
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }
        System.out.println("The last statement executed.");
    }

}
