package com.longhlk.trainings.websource.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebAccount {
    private int id;
    private String email;
    private String password;
    private String userName;
    private BigDecimal balance;
}
