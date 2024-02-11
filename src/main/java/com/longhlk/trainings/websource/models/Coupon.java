package com.longhlk.trainings.websource.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Coupon {
    private int id;
    private String code;
    private BigDecimal discount;
    private String expDate;

}
