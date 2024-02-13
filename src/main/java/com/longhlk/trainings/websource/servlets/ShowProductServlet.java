package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.models.Product;
import com.longhlk.trainings.websource.utils.ConnectionUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductDao.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("showProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}