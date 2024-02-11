package com.longhlk.trainings.websource.daos;

import com.longhlk.trainings.websource.models.Coupon;
import com.longhlk.trainings.websource.utils.ConnectionUtil;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CouponDao {
    List<Coupon> coupons = new ArrayList<>();
    public void addCoupon(Coupon coupon) {
        // Save coupon to database
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.
                    prepareStatement("insert into coupon values (?,?,?,?)");
            statement.setInt(1, coupon.getId());
            statement.setString(2, coupon.getCode());
            statement.setBigDecimal(3, coupon.getDiscount());
            statement.setString(4, coupon.getExpDate());
            int res = statement.executeUpdate();
            if (res == 1) {
                coupons.add(coupon);
                System.out.println("Coupon saved successfully");
            } else {
                System.out.println("Failed to save coupon");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCoupon(Coupon coupon) {
        // Update coupon
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update coupon set code = ?, discount = ?, exp_date = ? where id = ?");
            statement.setString(1, coupon.getCode());
            statement.setBigDecimal(2, coupon.getDiscount());
            statement.setString(3, coupon.getExpDate());
            statement.setInt(4, coupon.getId());
            int res = statement.executeUpdate();
            if (res == 1) {
                System.out.println("Coupon updated successfully");
            } else {
                System.out.println("Failed to update coupon");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Coupon> findByCode(String code) {
        // Find coupon by code
        Connection connection = ConnectionUtil.getConnection();
        List<Coupon> coupons = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from coupon where code = " + code);
            while (resultSet.next()) {
                Coupon coupon = new Coupon(
                        resultSet.getInt("id"),
                        resultSet.getString("code"),
                        resultSet.getBigDecimal("discount"),
                        resultSet.getString("exp_date")
                );
                coupons.add(coupon);
            }
            return coupons;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
