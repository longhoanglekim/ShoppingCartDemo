package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.models.Product;
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
        List<Product> products = ProductDao.getAllProducts();
        req.setAttribute("products", products);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("HomeServlet doPost");
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
