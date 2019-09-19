package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import com.example.demo.constant.ServiceConstant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QuickTestServiceConstant {

    @Test
    public void enumTEst() {
        String v1 = ServiceConstant.CONSTANT_1.getValue();
        String v2 = ServiceConstant.CONSTANT_2.getValue();

        assertEquals("first constant", v1);
        assertEquals("second constant", v2);
    }

    @Test
    public void staticTest() {
        String staticValue = ServiceConstant.staticValue();

        assertEquals("from static", staticValue);
    }

    @Test
    public void instanceTest() {
        ServiceConstant serviceConstant = ServiceConstant.CONSTANT_1;

        String instanceValue = serviceConstant.intanceValue();

        assertEquals("first constant", serviceConstant.getValue());
        assertEquals("from instance", instanceValue);
    }
}