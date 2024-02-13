package com.longhlk.trainings.websource.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/createProduct")
public class CreateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Create product");
        //Todo: Complete this function
        RequestDispatcher rd = req.getRequestDispatcher("createProduct.jsp");
        rd.forward(req, resp);
        System.out.println("Create product servlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Create product");
        //Todo: Complete this function
        RequestDispatcher rd = req.getRequestDispatcher("createProduct.jsp");
        rd.forward(req, resp);
    }
}
