package com.longhlk.trainings.websource.models;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
@Getter
@Setter
public class UserOrder {
    private int id;
    private int orderId;
    private Date orderDate;
}
