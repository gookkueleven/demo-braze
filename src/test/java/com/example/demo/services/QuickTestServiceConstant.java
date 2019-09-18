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
}