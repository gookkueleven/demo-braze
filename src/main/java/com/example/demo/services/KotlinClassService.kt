package com.example.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KotlinClassService(
        private val commonUtils: CommonUtils
) {

    fun printSomething(something: String): String {
        return "something has been printed $something"
    }

    fun dependencyInjection(): String {
        return commonUtils.callMeMaybe()
    }
}