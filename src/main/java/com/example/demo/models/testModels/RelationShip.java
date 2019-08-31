package com.example.demo.models.testModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationShip {

    private String spouseName;
    private String parentName;
    private String childName;
}
