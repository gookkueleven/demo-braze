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
        var atmos = dolby("audio", "Dolby ATMOS", 7, null)
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

    @Test
    fun `test groupBy in kotlin`() {

        val dolbyProduct = listOf(Dolby("sound", "ATMOS", 7),
        Dolby("vision", "VISION", 0),
        Dolby("sound", "AUDIO", 5))

        val dolbyProductGroupByType = dolbyProduct.groupBy { it.type }

        println(dolbyProductGroupByType)
    }

    @Test
    fun `test flatMap and list flatten`() {
        val dolbyProduct = listOf(Dolby("sound", "ATMOS", 7, listOf("DTS:X")),
                Dolby("vision", "VISION", 0, listOf("HDR10", "HDR10+", "HLG", "technicolor")),
                Dolby("sound", "AUDIO", 5, listOf("AAL")))

        val dolbyRivals = dolbyProduct.filter {
            it.type == "sound"
        }.flatMap { it.rivals!! }

        println(dolbyRivals)
    }
}