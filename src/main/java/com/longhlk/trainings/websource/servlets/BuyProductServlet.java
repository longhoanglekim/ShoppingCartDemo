package com.longhlk.trainings.websource.servlets;

import com.longhlk.trainings.websource.daos.ProductDao;
import com.longhlk.trainings.websource.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/buyProduct")
public class BuyProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BuyProductServlet doGet");
        if (req.getParameter("index") != null) {

            int index = Integer.parseInt(req.getParameter("index"));
            // Use the index to identify the product that the user wants to buy
            // Perform the necessary actions to process the purchase
            if (req.getSession().getAttribute("orderProducts") == null) {
                List<Product> orderProducts = new ArrayList<>();
                orderProducts.add(ProductDao.findProductByID(index));
                req.getSession().setAttribute("orderProducts", orderProducts);
            } else {
                List<Product> orderProducts = (List<Product>) req.getSession().getAttribute("orderProducts");
                orderProducts.add(ProductDao.findProductByID(index));
                req.getSession().setAttribute("orderProducts", orderProducts);
            }
            req.getRequestDispatcher("findProduct").forward(req, resp);
            System.out.println("Product with index " + index + " was add to your order.");
        } else {
            req.getRequestDispatcher("findProduct").forward(req, resp);
            System.out.println("Reload page");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
