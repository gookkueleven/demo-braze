package com.example.demo.models.testModels;

import lombok.Data;

@Data
public class GFriend {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
