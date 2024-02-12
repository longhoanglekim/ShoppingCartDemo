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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = ProductDao.getAllProducts();
        request.setAttribute("products", products);

        request.getRequestDispatcher("showProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        req.getRequestDispatcher("showProduct.jsp").include(req, resp);
    }
}