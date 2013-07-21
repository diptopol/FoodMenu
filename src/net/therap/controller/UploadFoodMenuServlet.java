package net.therap.controller;

import net.therap.implementation.FoodImpl;
import net.therap.interfaces.Food;
import net.therap.model.FoodMenuModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/9/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "UploadFoodMenuServlet")
public class UploadFoodMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] days = {"SUN","MON","TUE","WED","THURS"};
        String type = request.getParameter("type");

        FoodMenuModel foodMenuModel = new FoodMenuModel();
        List<Food> foodListDB = foodMenuModel.getFoodList(type);
        List<Food> foodList = new ArrayList<>();
        List<Food> foodListDoubled = new ArrayList<>();
        for(String day:days) {
            String items = request.getParameter(day);
            String[] splitItems = items.split(",");


            for(String item: splitItems) {
                if(!item.matches("")) {
                    Food food = new FoodImpl();
                    food.setType(type);
                    food.setItem(item);
                    food.setDay(day);
                    if(!foodListDB.contains(food))
                        foodList.add(food);
                    else foodListDoubled.add(food);
                }
            }
        }

        List<Food> foodListforDel = new ArrayList<>();
        for(Food food:foodListDB) {
            if(!foodListDoubled.contains(food)) {
                foodListforDel.add(food);
            }
        }


        foodMenuModel.deleteFromFoodList(foodListforDel);
        foodMenuModel.insertFoodList(foodList);
        response.sendRedirect("foodmenu?query="+type);

    }
}
