package com.example.demo.services;

import com.example.demo.constant.ColorCodeConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.services.TopLevelFunctionUtil.FRCPHR;
import static com.example.demo.services.TopLevelFunctionUtil.topLevelFunction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testSmartCastWithBlockExpression() {
        assertEquals("the windows has been open", kotlinService.testWhenWithSmartCastAndBlockExpression(slideWindows));
        assertEquals("the windows has been close", kotlinService.testWhenWithSmartCastAndBlockExpression(liftWindows));
    }

    @Test
    public void testRange() {
        kotlinService.testKotlinRange();
        kotlinService.testRangeWithDownToAndStep();
        kotlinService.testRangeWithOpenEndPoint();
        kotlinService.testUnpackingVariable();
    }

    @Test
    public void inChecking() {
        assertTrue(kotlinService.inForCheckingElementExistence('A'));
        assertTrue(kotlinService.inForCheckingElementExistence('a'));
        assertTrue(kotlinService.inForCheckingNonExistence('A'));
    }

    @Test
    public void createListWithKotlinListOf() {
        kotlinService.createListWithListOf();
    }

    @Test
    public void testKotlinDefaultFunctionValue() {
        kotlinService.forJavaDefaultParam();
    }

    @Test
    public void callTopLevelFunction() {
        TopLevelFunctionUtil.topLevelFunction();
        System.out.println(FRCPHR);
    }

    @Test
    public void testExtensionFunction() {
        String fromExt = TopLevelFunctionUtil.extendFunc(kotlinService);
        System.out.println(fromExt);
    }

    @Test
    public void testExtensionProperties() {
        String fromExt = TopLevelFunctionUtil.getExtendProps(kotlinService);
        System.out.println(fromExt);
    }
}
