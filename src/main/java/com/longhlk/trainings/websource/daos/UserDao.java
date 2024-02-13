package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.models.User;
import com.longhlk.trainings.websource.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static User getUser(String email, String password) {
        User user = null;
        Connection connection = ConnectionUtil.getConnection();
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                // set other fields if exist
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
