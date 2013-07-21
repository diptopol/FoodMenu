package net.therap.controller;

import net.therap.interfaces.User;
import net.therap.model.FoodMenuModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");


        FoodMenuModel foodMenuModel = new FoodMenuModel();
        User user = foodMenuModel.getUserbyUserName(userName.trim());

        if(user==null) {
            response.sendRedirect("loginform?message=no_user");

        }
        else if(!user.getPassWord().trim().equals(passWord.trim())) {
            response.sendRedirect("loginform?message=wrong_password");

        }

        else {
            HttpSession session = request.getSession();
            session.setAttribute("USER",user);
            response.sendRedirect("welcome");
        }


    }
}
