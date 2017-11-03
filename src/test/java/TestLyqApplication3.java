import com.haveacupofjava.happyfarm.Farmer;
import com.haveacupofjava.happyfarm.HappyFarm;
import com.haveacupofjava.happyfarm.creature.Pig;
import com.haveacupofjava.happyfarm.creature.group.AnimalGroup;
import com.haveacupofjava.happyfarm.factory.PigFactory;
import com.haveacupofjava.happyfarm.field.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestLyqApplication3 {

    public static void main(String[] args) {
        try {
//            List<Pig> a = new ArrayList<>();
//
//            Pig p = new Pig();
//            p.setWeight(100);
//            System.out.println(p.getWeight());
//            a.add(p);
//
//            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//            ObjectOutputStream out = new ObjectOutputStream(byteOut);
//            out.writeObject(a);
//            ByteArrayInputStream byteIn = new ByteArrayInputStream(
//                    byteOut.toByteArray());
//            ObjectInputStream in = new ObjectInputStream(byteIn);
//
//            List<Pig> b = (List<Pig>) in.readObject();
//
//            System.out.println(a.get(0).getWeight());
//            System.out.println(b.get(0).getWeight());
//
//            p.setWeight(200);
//
//            System.out.println(a.get(0).getWeight());
//            System.out.println(b.get(0).getWeight());

            Farmer.getInstance().buyField(new PigPenBuilder());
            Farmer.getInstance().buyAnimal(new PigFactory(),1);

//            List<AbstractField> field = HappyFarm.getInstance().fieldList;

            HappyFarm.getInstance().save();

//            AbstractFieldBuilder builder = new PigPenBuilder();
//            Director director = new Director(builder);
//            director.constructField();
//            PigPen field = (PigPen) builder.getField();
//            field.addAnimal(new Pig());
//
//
//            ByteArrayOutputStream byteOutField = new ByteArrayOutputStream();
//            ObjectOutputStream outField = new ObjectOutputStream(byteOutField);
//            outField.writeObject(field);

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
