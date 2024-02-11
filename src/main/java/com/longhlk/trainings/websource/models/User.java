package com.longhlk.trainings.websource.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String email;
    private String password;
}
