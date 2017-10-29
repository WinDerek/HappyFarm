package com.haveacupofjava.happyfarm.trade;

import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.creature.AbstractCreature;
import com.haveacupofjava.happyfarm.factory.AbstractAnimalFactory;
import com.haveacupofjava.happyfarm.factory.AbstractPlantFactory;
import com.haveacupofjava.happyfarm.security.MethodExposedException;

import java.util.ArrayList;
import java.util.List;

public class FactoryMediator extends AbstractMediator {

    private Integer number;

    @Override
    public void handleTrade() {
        Tradable seller = getSeller();
        List<AbstractCreature> list = new ArrayList<>();
        double price = 0.0;
        if (seller instanceof AbstractAnimalFactory) {
            price = ((AbstractAnimalFactory) seller).getAnimal().getSellingPrice();
            for (int i = 0; i < number; i++) {
                list.add(((AbstractAnimalFactory) seller).getAnimal());
            }
        } else if (seller instanceof AbstractPlantFactory) {
            price = ((AbstractPlantFactory) seller).getPlant().getSellingPrice();
            for (int i = 0; i < number; i++) {
                list.add(((AbstractPlantFactory) seller).getPlant());
            }
        } else {
            // TODO: Handle undefined factory in library
            System.out.println("Can not handle undefined factory.");
        }

        // Let the farmer pay money
        try {
            Farmer.getInstance().payMoney(price * number);
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }

        // Add the creatures into the fields in the farm
        try {
            HappyFarm.getInstance().addCreatures(list);
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Sets the trade information
     * @param number The number of AbstractCreature to buy
     */
    public void setTradeInfo(int number) {
        this.number = number;
    }

}

