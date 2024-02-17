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
import java.util.List;


@WebServlet(urlPatterns = "/findProduct")
public class FindProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("findProduct.jsp");
        rd.forward(req, resp);
        System.out.println("FindProductServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("Name...........");
        String priceParam = req.getParameter("price");
        BigDecimal price = null;
        if (priceParam != null && !priceParam.isEmpty()) {
            try {
                price = new BigDecimal(priceParam);
            } catch (NumberFormatException e) {
                // Handle the situation where priceParam is not a valid representation of a BigDecimal
                System.out.println("Invalid price parameter: " + priceParam);
            }
        }
        System.out.println("Price...........");
        List<Product> productList = ProductDao.getFoundProducts(name, price);
        System.out.println("Get the found product list!");
        req.setAttribute("productList", productList); // change here
        RequestDispatcher rd = req.getRequestDispatcher("findProduct.jsp");
        rd.include(req, resp);
        System.out.println("FindProductServlet doPost");
    }

}
