package com.haveacupofjava.happyfarm.task;

/**
  * Class AbstractManagerHandler
  * handle command from farmer
  */
public abstract class AbstractManagerHandler {
    protected AbstractManagerHandler nextManager;

    /**
      * handle request from farmer
      * @param request The request to be handled
      */
    public final void handleRequest(Request request){
        if (getRequestCategory() == request.getCategory()) {
            handle(request);
        } else {
            if (nextManager != null) {
                nextManager.handleRequest(request);
            } else {
                System.out.println("All of handlers can not handle the request.");
            }
        }
    }

    public final void setNext(AbstractManagerHandler nextManager) {
        this.nextManager = nextManager;
    }

    /**
      * Gets the handle level of this
      * @return handle level
      */
    protected abstract RequestCategory getRequestCategory();

    /**
      * handle the request
      * @param request The request to handle
      * @author Yiqun Lin
      */
    protected abstract void handle(Request request);

}
