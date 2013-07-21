package net.therap.implementation;

import net.therap.interfaces.Food;
import net.therap.interfaces.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/8/13
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class FoodRowMapper implements ObjectRowMapper{
    @Override
    public Object mapRowtoObject(ResultSet resultSet) {

        Food food = new FoodImpl();
        try {

            food.setDay(resultSet.getString("DAY"));
            food.setItem(resultSet.getString("ITEM"));
            food.setType(resultSet.getString("TYPE"));

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return food;
    }
}
