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

@WebServlet(urlPatterns = "/showOrder")
public class ShowOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ShowOrderServlet doGet");
        if (req.getSession().getAttribute("orderProducts") == null) {
            System.out.println("OrderProducts is null");
        } else {
            List<Product> orderProducts = (List<Product>) req.getSession().getAttribute("orderProducts");
            for (Product product : orderProducts) {
                System.out.println(product.getName());
            }
        }
        req.getRequestDispatcher("showOrder.jsp").forward(req, resp);
    }
}
