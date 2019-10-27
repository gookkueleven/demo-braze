package com.example.demo.services

import com.example.demo.services.interfaces.Windows

class SlideWindows(
): Windows() {
    override fun open() {
        status = "open";
    }

    override fun close() {
        status = "close"
    }

    override fun checkStatus() {
        println(status)
    }
}