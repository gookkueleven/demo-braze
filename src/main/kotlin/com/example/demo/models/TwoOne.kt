package com.example.demo.models

data class TwoOne<T, K>(
        private val first: T,
        private val second: K
) {
    val one = first
    val two = second
    val pair = "String" to 123
}