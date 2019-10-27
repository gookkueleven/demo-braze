package com.example.demo.services;

import com.example.demo.constant.ColorCodeConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class QuickTestKotlinService {

    private KotlinService kotlinService;

    private SlideWindows slideWindows;
    private LiftWindows liftWindows;

    @Before
    public void setUp() {
        kotlinService = new KotlinService();

        slideWindows = new SlideWindows();
        liftWindows = new LiftWindows();
    }

    @Test
    public void testHelloWorld() {
        kotlinService.testPersonKt();
        kotlinService.testCreateJavaObject();
        kotlinService.testGetValProperty();
    }

    @Test
    public void testKotlinEnumConstant() {
        assertEquals(255, ColorCodeConstant.RED.getRed());
        assertEquals(0, ColorCodeConstant.RED.getGreen());
        assertEquals(0, ColorCodeConstant.RED.getBlue());
    }

    @Test
    public void testWhenExpressionBody() {
        assertEquals("Green is wood", kotlinService.testWhenWithExpressionBody(ColorCodeConstant.GREEN));
        assertEquals("Main HUE", kotlinService.testWhenWithMultipleBranch(ColorCodeConstant.GREEN));
        assertEquals("Not main HUE", kotlinService.testWhenWithMultipleBranch(ColorCodeConstant.MAGENTA));
        assertEquals(ColorCodeConstant.RED, kotlinService.testSetOf(ColorCodeConstant.RED, ColorCodeConstant.RED));
    }

    @Test
    public void testInterfaceWindows() {
        slideWindows.checkStatus();
        slideWindows.open();
        slideWindows.checkStatus();

        assertEquals("open", slideWindows.getStatus());
    }

    @Test
    public void testSmartCast() {
        slideWindows.open();
        assertEquals("open", kotlinService.testSmartCast(slideWindows));
        assertEquals("this is not a slide windows", kotlinService.testSmartCast(liftWindows));
    }
}
