import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.factory.WheatFactory;

public class Test {
    public static void main(String[] args) throws Exception{
        Farmer farmer = Farmer.getInstance();
        farmer.buyAnimal(new PigFactory(), 10);
        farmer.buyPlant(new WheatFactory(), 10);
    }
}
