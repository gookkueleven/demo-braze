package com.example.demo.constant;

public enum ServiceConstant {

    CONSTANT_1("first constant"), CONSTANT_2("second constant");

    private String value;

    private ServiceConstant(String value) {
        this.value = value;
    }

    public static String staticValue() {
        return "from static";
    }

    public String getValue() {
        return this.value;
    }

    public String intanceValue() {
        return "from instance";
    }
}