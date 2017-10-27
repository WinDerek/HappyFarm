import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;

public class TestApplication1 {

    public static void main(String[] args) {
        Farmer farmer = Farmer.getInstance();
        HappyFarm happyFarm = HappyFarm.getInstance();
        happyFarm.showFieldsInformation();
    }

}
