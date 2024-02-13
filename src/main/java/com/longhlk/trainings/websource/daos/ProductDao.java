package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.models.Product;
import com.longhlk.trainings.websource.utils.ConnectionUtil;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static boolean addProduct(Product product) {
        // Add product
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product (name,description,price) values (?,?,?)");
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            int res = statement.executeUpdate();
            if (res > 0) {
                System.out.println("Product added successfully");
                return true;
            } else {
                System.out.println("Product not added");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateProduct(Product product) {
        // Update product
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update product set name = ?, description = ?, price = ?, coupon_code = ? where id = ?");
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBigDecimal(3, product.getPrice());
            statement.setInt(5, product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  List<Product> getAllProducts() {
        // Get all products
        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt("id"));
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                product.setPrice(res.getBigDecimal("price"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {


    }
}
