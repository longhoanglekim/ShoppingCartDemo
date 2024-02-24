package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderProductDao {
    public static int getCurrentOrderID() {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement= connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(order_id) FROM order_product");
            if (rs.next()) {
                int id = rs.getInt(1);
                if (id == 0) {
                    System.out.println("No order found");
                }
                return id + 1;
            } else {
                System.out.println("No order found");
                return 1; // If no orders, start with 1
            }
        } catch (SQLException e) {
            System.out.println("Error in getting order id");
            e.printStackTrace();
        }
        return 0;
    }
}
