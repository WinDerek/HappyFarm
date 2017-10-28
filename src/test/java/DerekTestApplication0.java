import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.creature.Sheep;
import com.haveacupofjava.happyfarm.field.PigPen;

public class DerekTestApplication0 {

    public static void main(String[] args) {
        Pig pig = new Pig();
        PigPen pigPen = new PigPen();
        System.out.println(pigPen.isCreatureMatch(Pig.class));
        System.out.println(pigPen.isCreatureMatch(Sheep.class));
    }

}
