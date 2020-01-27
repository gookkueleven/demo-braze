package com.example.demo.services.interfaces

abstract class Windows(
        open var status: String = "close"
) {
    abstract fun open()
    abstract fun close()
    abstract fun checkStatus()
}