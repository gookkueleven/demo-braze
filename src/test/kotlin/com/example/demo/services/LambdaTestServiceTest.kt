package com.example.demo.services

import com.example.demo.models.Dolby
import org.junit.Assert
import org.junit.Test

class LambdaTestServiceTest {
    private val lambdaTestService = LambdaTestService()

    @Test
    fun test_lambda() {
        val returnVal = lambdaTestService.lambdaValue(10)
        val trueOrFalse = lambdaTestService.isTen(lambdaTestService.lambdaValue(10))

        Assert.assertEquals("ten", returnVal)
        Assert.assertTrue(trueOrFalse)
    }

    @Test
    fun test_ThreeTwoOne() {
        lambdaTestService.testThreeTwoOne()
    }

    @Test
    fun test_maxBy() {
        lambdaTestService.testMaxBy()
    }

    @Test
    fun test_memberReference() {
        print(KotlinService::serviceName)
    }

    @Test
    fun postpone_creating_class_instance_with_member_reference() {
        var dolby = ::Dolby
        var atmos = dolby("audio", "atmos", 7)
    }
}