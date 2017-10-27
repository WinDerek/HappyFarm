package com.haveacupofjava.happyfarm.factory;

public class FactoryMediator extends AbstractMediator {

    private Class clazz;
    private Integer number;

    @Override
    public void handleTrade() {
        AbstractFactory abstractFactory = null;

        try {
            abstractFactory = (AbstractFactory) Class.forName(clazz.getName()).newInstance();
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Sets the trade information
     * @param clazz The Class of AbstractFactory
     * @param number The number of AbstractCreature to buy
     */
    public void setTradInfo(Class clazz, int number) {
        this.clazz = clazz;
        this.number = number;
    }

}
