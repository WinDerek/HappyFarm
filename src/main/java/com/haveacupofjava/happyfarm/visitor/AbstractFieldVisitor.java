package com.haveacupofjava.happyfarm.visitor;

import com.haveacupofjava.happyfarm.field.AbstractFarmland;
import com.haveacupofjava.happyfarm.field.AbstractPen;

public interface AbstractFieldVisitor {

    void visit(AbstractPen pen);

    void visit(AbstractFarmland farmLand);

}
