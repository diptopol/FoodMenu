package net.therap.implementation;

import net.therap.interfaces.Food;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/8/13
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class FoodImpl implements Food{
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Food) {
            Food otherFood = (Food) obj;
            if(this.day.equals(otherFood.getDay()) && this.item.equals(otherFood.getItem()) && this.type.equals(otherFood.getType()))
                return true;
            else return false;
        }
        else return false;
    }

    private String item;
    private String type;
    private String day;

    @Override
    public String getItem() {
        return this.item;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getDay() {
        return this.day;
    }

    @Override
    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setDay(String day) {
        this.day = day;
    }
}
