import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.field.Director;
import com.haveacupofjava.happyfarm.field.WheatFarmlandBuilder;

public class TestLyqApplication1 {
    public static void main(String[] args){
        WheatFarmlandBuilder builder = new WheatFarmlandBuilder();

        Director director = new Director(builder);

        director.constructField();

        AbstractField land = builder.getField();
        land.showField();

        System.out.println(land.getClass().getName());

        // builder = new Builder();
        // farmer.buyField(builder);
    }
}
