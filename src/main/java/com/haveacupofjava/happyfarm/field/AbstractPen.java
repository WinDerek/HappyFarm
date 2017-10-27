package com.haveacupofjava.happyfarm.field;

import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;

/**
  * Class AbstractPen
  * pen to rear livestock
  * @author Yiqun Lin
  */
public abstract class AbstractPen extends AbstractField {
    protected AnimalGroup animalGroup = new AnimalGroup();
}
