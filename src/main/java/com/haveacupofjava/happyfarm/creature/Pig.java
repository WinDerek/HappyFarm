package com.haveacupofjava.happyfarm.creature;

/**
  * Class Pig
  * Definition for pig
  * @author Yichao Wu
  */
public class Pig extends AbstractVivipara{

    private String name;

    @Override
    void produce() {

        System.out.println("hey, pig milk!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
