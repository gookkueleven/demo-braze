package com.example.demo.services

import com.example.demo.services.interfaces.Vehicle

open class Cars (
        val wheel: Int = 4,
        val engine: String = "4 tubes",
        val color: String = "white",
        val door: Int = 4,
        val choke: String? = null
): Vehicle {
    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}