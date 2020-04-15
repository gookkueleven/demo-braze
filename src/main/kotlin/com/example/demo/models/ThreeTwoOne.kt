package com.example.demo.models

data class ThreeTwoOne<T, K, O>(private val first: T, private val second:K, private val third:O) {
    val one = first
    val two = second
    val three = third

    val pair = "a" to "c"
}