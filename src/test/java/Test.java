import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.factory.WheatFactory;

public class Test {
    public static void main(String[] args) throws Exception{
        Farmer farmer = Farmer.getInstance();
        WheatFactory factory = new WheatFactory();
        Wheat wheat = (Wheat)factory.getPlant();
        wheat.addObserver(farmer);
        wheat.produce();
        PigFactory pigFactory = new PigFactory();
        Pig pig = (Pig)pigFactory.getAnimal();
        pig.addObserver(farmer);
        pig.produce();
    }
}
