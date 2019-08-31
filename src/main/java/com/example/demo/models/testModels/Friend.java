package com.example.demo.models.testModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {

    private String name;
    private String lastName;
    private Integer age;

    private GFriend gFriend;
    private FParent fParent;
}
