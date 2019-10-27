package com.example.demo.services.interfaces

abstract class Windows(
    var status: String = "close"
) {
    abstract fun open()
    abstract fun close()
    abstract fun checkStatus()
}