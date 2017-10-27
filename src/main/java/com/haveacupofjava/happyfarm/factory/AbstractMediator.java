package com.haveacupofjava.happyfarm.factory;

import com.haveacupofjava.happyfarm.trade.Tradable;

public abstract class AbstractMediator {

    private Tradable buyer;
    private Tradable seller;

    public void setBuyer(Tradable buyer) {
        this.buyer = buyer;
    }

    public void setSeller(Tradable seller) {
        this.seller = seller;
    }

    public abstract void handleTrade();

}
