package org.derekdaisy.happyfarm.field;

import org.derekdaisy.happyfarm.CookHelper;
/**
 * @author XuantangCun E-mail:Tang_zhu0@163.com
 * @version 创建时间：2017-10-24
 *
 */
public abstract class Food {
    protected CookHelper cookHelper;

    public Food(CookHelper cookHelper){
        this.cookHelper = cookHelper;
    }

    public abstract void cook();
}
