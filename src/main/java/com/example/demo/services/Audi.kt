package com.example.demo.services

data class Audi(
        val company: String = "Audi motor"
): Cars() {

    override fun start() {
        print("Audi's engine has been ignited")
    }

    override fun stop() {
        print("cooling down")
    }
}