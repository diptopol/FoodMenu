package net.therap.controller;

import net.therap.interfaces.Food;
import net.therap.model.FoodMenuModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/8/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "EditFoodMenuServlet")
public class EditFoodMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("query");
        FoodMenuModel foodMenuModel = new FoodMenuModel();
        List<Food> foodList = foodMenuModel.getFoodList(type);
        HashMap<String,String> foodMap = new HashMap<>();

        String[] days = {"SUN","MON","TUE","WED","THURS"};

        for(String day:days) {
            StringBuilder items = new StringBuilder();
            for(Food food:foodList) {
                if(food.getDay().equals(day)) {
                    items.append(food.getItem()+",");
                }

            }
            if(items.length()!=0)  items.deleteCharAt(items.length()-1);
            foodMap.put(day,items.toString());

        }

        request.setAttribute("FOOD_MAP",foodMap);
        request.setAttribute("FOOD_TYPE",type);
        request.setAttribute("DAYS", Arrays.asList(days));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/restricted/EditFoodMenu.jsp");
        requestDispatcher.forward(request,response);

    }
}
