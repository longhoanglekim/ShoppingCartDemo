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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM web_account WHERE email = '" + email + "'");
            RequestDispatcher rd = null;
            if (res.next()) {
                res = statement.executeQuery("SELECT * FROM web_account WHERE email ='" + email + "' AND password = '" + password + "'");

                if (res.next()) {
                    System.out.println("Login success");
                    rd = req.getRequestDispatcher("/home");
                    rd.forward(req, resp);
                } else {
                    rd = req.getRequestDispatcher("login.jsp");
                    rd.forward(req, resp);
                    System.out.println("Invalid password");
                    //Todo:Complete the front-end
                }
            } else {
                rd = req.getRequestDispatcher("login.jsp");
                rd.forward(req, resp);
                System.out.println("Invalid email");
                //Todo:Complete the front-end
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
