package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.utils.ConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        System.out.println("LoginServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet doPost");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM web_account WHERE email = '" + email + "'");

            System.out.println("Find email");
            RequestDispatcher rd = null;
            if (res.next()) {
                res = statement.executeQuery("SELECT * FROM web_account WHERE email ='" + email + "' AND password = '" + password + "'");
                if (res.next()) {
                    System.out.println("Login success");
                    req.getSession().setAttribute("user", email);
                    rd = req.getRequestDispatcher("/home");
                    rd.forward(req, resp);
                } else {
                    rd = req.getRequestDispatcher("login.jsp");
                    rd.forward(req, resp);
                    System.out.println("Invalid password");
                    //Todo:Complete the front-end
                }
            } else  {
                rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
                System.out.println("Invalid email");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
