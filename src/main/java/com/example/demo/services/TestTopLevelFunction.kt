@file:JvmName("TopLevelFunctionUtil")

package com.example.demo.services

const val FRCPHR = "CRUSH"

val KotlinService.extendProps: String
    get() {
        return "getter must be declare when create extension properties from $serviceName"
    }

fun topLevelFunction() {
    println("I am the top level function")
}

fun KotlinService.extendFunc(): String {
    return "this one is get from  KotlinService class function ${omitReturnType()}"
}
