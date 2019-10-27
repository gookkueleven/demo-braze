package com.example.demo.models.kotlin

class Rectangle(
        val width: Int,
        val height: Int
) {
    val isSquare get() = height == width
}