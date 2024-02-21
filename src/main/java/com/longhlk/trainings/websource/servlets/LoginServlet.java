package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.WebAccountDAO;
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
            if (WebAccountDAO.findUser(email)) {
                if (WebAccountDAO.checkPassword(email, password)) {
                    System.out.println("Login success");
                    req.getSession().setAttribute("userName", WebAccountDAO.getName(email));
                    req.getSession().setAttribute("user", email);
                    resp.sendRedirect("home");
                } else {
                    System.out.println("Invalid password");
                    req.setAttribute("message", "Invalid password");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                System.out.println("Invalid email");
                req.setAttribute("message", "Invalid email");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
