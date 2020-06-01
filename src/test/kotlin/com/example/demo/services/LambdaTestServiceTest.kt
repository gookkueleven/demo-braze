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
        var atmos = dolby("audio", "Dolby ATMOS", 7)
        val atmosNameFunction = Dolby::name
        val itSelfNameFunction = atmos::name

        print(atmosNameFunction(atmos))
        print(itSelfNameFunction)
    }

    @Test
    fun create_map_and_filter_it() {
        val mapJaa = mapOf(
                "kook" to "ku",
                "dog" to "cat",
                "card" to "casino"
        )

        println(mapJaa.filter {
            it.key == "kook"
        }.values)

        println(mapJaa.filterKeys {
            it == "kook"
        }.values)

        println(mapJaa.filterValues {
            it == "ku"
        }.keys)
    }

    @Test
    fun `create predicate using lambda`() {

        val isDolbySurrondSound = { dolby: Dolby -> dolby.channel == 7 }

        val dolbyList = listOf(
                Dolby("audio", "audio", 2),
                Dolby("vision", "vision", 0),
                Dolby("atmos", "atmos", 7)
        )

        val countDolby = dolbyList.count(isDolbySurrondSound)
        val findDolbyAtmos = dolbyList.find(isDolbySurrondSound)
        val anyDolbyAtmos = dolbyList.any(isDolbySurrondSound)
        val allDolby = dolbyList.all(isDolbySurrondSound)

        println(countDolby)
        println(findDolbyAtmos)
        println(anyDolbyAtmos)
        println(allDolby)
    }
}