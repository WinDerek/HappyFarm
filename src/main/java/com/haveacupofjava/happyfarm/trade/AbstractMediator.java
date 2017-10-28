package com.haveacupofjava.happyfarm.trade;

/**
  * Class AbstractMediator
  * Abstract mediator of market mediator and factory mediator
  * @author Yichao Wu
  */
public abstract class AbstractMediator {
    private Tradable buyer;
    private Tradable seller;

    Tradable getBuyer() {
        return buyer;
    }

    Tradable getSeller() {
        return seller;
    }

    public void setBuyer(Tradable buyer) {
        this.buyer = buyer;
    }

    public void setSeller(Tradable seller) {
        this.seller = seller;
    }

    /**
      * Handle the trade process
      * @author Yichao Wu
      */
    public abstract void handleTrade();
}
