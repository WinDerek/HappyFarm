package com.haveacupofjava.happyfarm.visitor;

import com.haveacupofjava.happyfarm.field.AbstractFarmLand;
import com.haveacupofjava.happyfarm.field.AbstractPen;

public interface AbstractFieldVisitor {

    void visit(AbstractPen pen);

    void visit(AbstractFarmLand farmLand);

}
