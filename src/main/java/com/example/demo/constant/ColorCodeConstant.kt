package com.example.demo.constant

enum class ColorCodeConstant(
        private val r: Int,
        private val g: Int,
        private val b: Int
) {
    RED(255, 0, 0),
    GREEN(0, 255, 255),
    BLUE(0, 0, 255),
    MAGENTA(255, 0, 255),
    BLACK(0, 0,0);

    fun getRed(): Int {
        return this.r
    }

    fun getGreen(): Int {
        return this.g
    }

    fun getBlue(): Int {
        return this.b
    }
}