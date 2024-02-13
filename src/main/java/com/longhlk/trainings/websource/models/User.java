package com.longhlk.trainings.websource.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String email;
    private String password;
}
