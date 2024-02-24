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

@WebServlet(urlPatterns = "/buyProduct")
public class BuyProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BuyProductServlet doGet");
        int index = Integer.parseInt(req.getParameter("index"));
        // Use the index to identify the product that the user wants to buy
        // Perform the necessary actions to process the purchase
        Product clikedProduct = ProductDao.getAllProducts().get(index);

        System.out.println("Product with index " + index + " was bought.");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BuyProductServlet doPost");
    }
}
