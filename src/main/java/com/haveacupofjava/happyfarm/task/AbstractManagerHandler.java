package com.haveacupofjava.happyfarm.task;

/**
  * Class AbstractManagerHandler
  * handle command from farmer
  * @author Yiqun Lin
  */
public abstract class AbstractManagerHandler {
    protected AbstractManagerHandler nextManager;

    /**
      * handle request from farmer
      * @param Request
      * @author Yiqun Lin
      */
    public final void handleRequest(Request request){
        if(getRequestCategory() == request.getCategory()){
            handle(request);
        }else{
            if(nextManager != null){
                nextManager.handleRequest(request);
            }else{
                System.out.println("All of handlers can not handle the request.");
            }
        }
    }

    public final void setNext(AbstractManagerHandler nextManager){
        this.nextManager = nextManager;
    }

    /**
      * get the handle level of this
      * @return handle level
      * @author Yiqun Lin
      */
    protected abstract RequestCategory getRequestCategory();

    /**
      * handle the request
      * @param Request to handle
      * @author Yiqun Lin
      */
    protected abstract void handle(Request request);
}
