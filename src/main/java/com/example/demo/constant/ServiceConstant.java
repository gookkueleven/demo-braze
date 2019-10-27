package com.example.demo.constant;

public enum ServiceConstant {

    CONSTANT_1("first constant", "value2"), CONSTANT_2("second constant", "value2");

    private String value;
    private String value2;

    private ServiceConstant(String value, String value2) {
        this.value = value;
        this.value2 = value2;
    }

    public static String staticValue() {
        return "from static";
    }

    public String getValue() {
        return this.value;
    }

    public String getValue2() {
        return this.value2;
    }

    public String intanceValue() {
        return "from instance";
    }
}