package com.haveacupofjava.happyfarm.trade;

import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.produce.AbstractProduce;
import com.haveacupofjava.happyfarm.security.MethodExposedException;

import java.util.List;

public class MarketMediator extends AbstractMediator {

    private List<AbstractProduce> produceList;

    public void setProduceList(List<AbstractProduce> produceList) {
        this.produceList = produceList;
    }

    @Override
    public void handleTrade() {
        // Let the farmer gain some money
        double amount = produceList.get(0).getPrice() * produceList.size();
        try {
            Farmer.getInstance().gainMoney(amount);
        } catch (MethodExposedException exception) {
            exception.printStackTrace(System.out);
        }

        System.out.println(produceList.size() + " " +
                produceList.get(0).getClass().getSimpleName() + "s are sold for money " +
                amount + ".");
    }

}
