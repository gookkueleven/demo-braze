package com.example.demo.models.testModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private String lastName;
    private Integer age;

    private RelationShip relationShip;
}
