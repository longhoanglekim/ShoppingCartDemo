package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.OrderProductDao;
import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.daos.WebAccountDAO;
import com.longhlk.trainings.websource.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeServlet doGet");
        loadPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeServlet doPost");
        loadPage(req, resp);
    }

    private void loadPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAttribute(req);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }


    public void setAttribute(HttpServletRequest req) {
        String user = (String) req.getSession().getAttribute("user");
        //System.out.println("User: " + user);
        String userName = (String) req.getSession().getAttribute("userName");
        if (req.getSession().getAttribute("userName") == null) {
            req.getSession().setAttribute("userName", userName);
        }
        if (req.getSession().getAttribute("balance") == null) {
            String balance = WebAccountDAO.getBalance(user).toString();
            balance = balance.concat("$");
            req.getSession().setAttribute("balance", balance);
            //System.out.println("Balance: " + balance);
        } else {
            System.out.println("Balance not null");
        }

    }
}
