import com.haveacupofjava.happyfarm.field.AbstractField;
import com.haveacupofjava.happyfarm.product.AbstractProduct;
import com.haveacupofjava.happyfarm.product.AbstractTool;

public class PigProductionStimulator extends AbstractTool {

    public PigProductionStimulator() {
        setName(getClass().getSimpleName());
        setPrice(4.0);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        PigProductionStimulator pigProductionStimulator = new PigProductionStimulator();
        pigProductionStimulator.setName(getName());
        pigProductionStimulator.setPrice(getPrice());
        return pigProductionStimulator;
    }

    @Override
    public void handleField(AbstractField field) {
        field.stimulateProduction();
        field.showField();
    }

}
