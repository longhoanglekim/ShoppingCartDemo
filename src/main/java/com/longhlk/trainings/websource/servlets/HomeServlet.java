package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.daos.WebAccountDAO;
import com.longhlk.trainings.websource.models.Product;
import com.longhlk.trainings.websource.models.WebAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        String user = (String) req.getSession().getAttribute("user");
        //System.out.println("User: " + user);
        String userName = (String) req.getSession().getAttribute("userName");
        req.getSession().setAttribute("userName", userName);
        String balance = WebAccountDAO.getBalance(user).toString();
        balance = balance.concat("$");
        req.getSession().setAttribute("balance", balance);
        System.out.println(userName);
        List<Product> products = ProductDao.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
