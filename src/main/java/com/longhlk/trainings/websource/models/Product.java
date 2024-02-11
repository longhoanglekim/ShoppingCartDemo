package com.longhlk.trainings.websource.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
