import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.creature.Wheat;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.factory.SheepFactory;
import com.haveacupofjava.happyfarm.factory.WheatFactory;
import com.haveacupofjava.happyfarm.field.PigPen;
import com.haveacupofjava.happyfarm.field.WheatFarmland;

import java.lang.reflect.ParameterizedType;

public class Test {
    public static void main(String[] args) throws Exception{
        Farmer farmer = Farmer.getInstance();
        farmer.buyAnimal(new PigFactory(), 10);
        farmer.buyPlant(new WheatFactory(), 10);
    }
}
