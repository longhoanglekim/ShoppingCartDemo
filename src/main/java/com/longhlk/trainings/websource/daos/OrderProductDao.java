package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.utils.ConnectionUtil;

import java.sql.*;

public class OrderProductDao {
    public static int getCurrentOrderID() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT MAX(order_id) FROM order_product");
            if (rs.next()) {
                int id = rs.getInt(1);
                if (id == 0) {
                    System.out.println("No order found");
                }
                return id + 1;
            } else {
                System.out.println("No order found");
                return -1; // If no orders, start with 1
            }
        } catch (SQLException e) {
            System.out.println("Error in getting order id");
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
