import com.haveacupofjava.happyfarm.field.Director;
import com.haveacupofjava.happyfarm.field.WheatFarmLand;
import com.haveacupofjava.happyfarm.field.WheatFarmlandBuild;

public class TestLyqApplication1 {
    public static void main(String[] args){
        WheatFarmlandBuild builder = new WheatFarmlandBuild();
        Director director = new Director(builder);
        director.constructField();

        WheatFarmLand land = (WheatFarmLand) director.getProduct();
        land.showField();

        // farmer.buyField(AbstractBuilder)
    }
}
