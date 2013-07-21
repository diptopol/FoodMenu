package net.therap.model;

import net.therap.database.DatabaseTemplate;
import net.therap.implementation.FoodRowMapper;
import net.therap.implementation.UserRowMapper;
import net.therap.interfaces.Food;
import net.therap.interfaces.ObjectRowMapper;
import net.therap.interfaces.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodMenuModel {

    public FoodMenuModel() {
    }

    public User getUserbyUserName(String userName) {


        ObjectRowMapper<User> objectRowMapper = new UserRowMapper();
        String query="select * from USERS where USERNAME='"+userName+"'";
        System.out.println(query);
        List<User> userList = DatabaseTemplate.getQueryObjects(query, objectRowMapper);

        if(userList.isEmpty())
            return null;
        else return userList.get(0);

    }

    public List<Food> getFoodList(String type) {
        ObjectRowMapper<Food> foodObjectRowMapper = new FoodRowMapper();
        String query = "select * from FOODMENU where TYPE='"+type+"'";
        List<Food> foodList = DatabaseTemplate.getQueryObjects(query,foodObjectRowMapper);

        return foodList;

    }

    public void insertFoodList(List<Food> foodList) {

        String query = "INSERT into FOODMENU (TYPE, ITEM, DAY) VALUES (?,?,?)";

        for(Food food:foodList) {

            DatabaseTemplate.executeQuery(query, food.getType(), food.getItem(), food.getDay());
        }

    }

    public void deleteFromFoodList(List<Food> foodList) {
        String query = "DELETE FROM FOODMENU WHERE TYPE = ? AND ITEM = ? AND DAY = ?";
        for(Food food:foodList) {
            DatabaseTemplate.executeQuery(query, food.getType(), food.getItem(), food.getDay());
        }
    }

}
