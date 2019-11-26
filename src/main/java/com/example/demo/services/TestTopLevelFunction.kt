@file:JvmName("TopLevelFunctionUtil")

package com.example.demo.services

const val FRCPHR = "CRUSH"

fun topLevelFunction() {
    println("I am the top level function")
}

fun KotlinService.extendFunc(): String {
    return "this one is get from  KotlinService class function ${omitReturnType()}"
}

