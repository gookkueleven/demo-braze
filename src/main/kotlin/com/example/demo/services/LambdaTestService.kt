package com.example.demo.services

import com.example.demo.models.Dolby
import com.example.demo.models.ThreeTwoOne
import com.example.demo.models.testModels.ButtonLess
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

    fun testMaxBy (level: Int = 0) {
        val name = "Dolby"
        val listOfAge = listOf(12, 13, 14, 15)

        val nameNAge = listOfAge.forEach {
            print("$it $name $level")
        }
    }

    fun learnLambdaMemberReference(): Int {
        val dolby = Dolby("Audio", "Dolby Audio", 5)
        return dolby.channel!!
    }


}