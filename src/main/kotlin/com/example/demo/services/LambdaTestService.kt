package com.example.demo.services

import com.example.demo.models.ThreeTwoOne
import org.springframework.stereotype.Service

@Service
class LambdaTestService {

    val lambdaValue = { age: Int -> when(age) {
        10 -> "ten"
        else -> "Other number"
    } }

    fun isTen(number: String): Boolean {
        return "ten".equals(number, true)
    }

    fun testThreeTwoOne() {
        val testClass = ThreeTwoOne<String, Int, Boolean>("Kook", 26, true)
        print(testClass)
    }
}