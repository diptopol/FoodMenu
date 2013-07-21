package net.therap.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/17/13
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LogInFormServlet")
public class LogInFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
          requestDispatcher.forward(request,response);
    }
}
