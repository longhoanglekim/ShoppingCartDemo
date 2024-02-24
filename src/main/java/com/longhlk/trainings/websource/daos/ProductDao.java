package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.models.Product;
import com.longhlk.trainings.websource.utils.ConnectionUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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


    public static List<Product> getFoundProducts(String name, BigDecimal price) {
        Connection connection = ConnectionUtil.getConnection();
        if (name != null && price != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from product where  name=? and price =?");
                preparedStatement.setString(1, name);
                preparedStatement.setBigDecimal(2, price);
                return selectProductQuery(preparedStatement);
            } catch (SQLException e) {
                System.out.println("Error at sqlFoundProduct");
                e.printStackTrace();
            }
        }
        if (name != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from product where  name=?");
                preparedStatement.setString(1, name);
                return selectProductQuery(preparedStatement);
            } catch (SQLException e) {
                System.out.println("Error at sqlFoundProduct");
                e.printStackTrace();
            }
        }
        if (price != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from product where price =?");
                preparedStatement.setBigDecimal(1, price);
                return selectProductQuery(preparedStatement);
            } catch (SQLException e) {
                System.out.println("Error at sqlFoundProduct");
                e.printStackTrace();
            }
        }
        System.out.println("You haven't type the properties!");
        return null;
    }

    private static List<Product> selectProductQuery(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setPrice(resultSet.getBigDecimal(4));
            products.add(product);
        }
        return products;
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

    public static void deleteProduct(int id) {
        // Delete product
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from product where id = ?");
            statement.setInt(1, id);
            int res = statement.executeUpdate();
            if (res > 0) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


    }

}
