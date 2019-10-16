package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CommonUtils {

    public static String randomString() {
        return "random string";
    }

    public String callMeMaybe() {
        return "This is my number";
    }
    
}