package com.example.demo.kotlinServices

import com.example.demo.services.Audi
import com.example.demo.services.Cars
import com.example.demo.services.KotlinService
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestCars {

    @Test
    fun `check default car`() {
        val newCar = Cars()

        assertEquals(4, newCar.wheel)
        assertEquals("4 tubes", newCar.engine)
        assertEquals("white", newCar.color)
        assertEquals(4, newCar.door)
    }

    @Test
    fun `object equality checking`() {
        val car1 = Audi()
        val car2 = Audi()

        //check instance equality
        println(car1 == car2)

        //check reference equality
        println(car1 === car2)
    }

}