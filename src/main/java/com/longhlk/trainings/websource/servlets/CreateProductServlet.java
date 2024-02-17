package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.models.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/createProduct")
public class CreateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("createProduct.jsp");
        rd.forward(req, resp);
        System.out.println("Create product servlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Create product");
        //Todo: Complete this function
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setDescription(req.getParameter("description"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        product.setPrice(price);
        if (ProductDao.addProduct(product)) {
            req.setAttribute("productAdded", true);
            resp.sendRedirect("showProduct");
        } else {
            resp.sendRedirect("createProduct");
        }
    }
}
