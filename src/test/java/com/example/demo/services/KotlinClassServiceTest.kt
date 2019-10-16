package com.example.demo.services

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertEquals

internal class KotlinClassServiceTest {

    private val commonUtils: CommonUtils = mockk()

    private val kotlinClassService: KotlinClassService = KotlinClassService(commonUtils)

    @BeforeEach
    fun setUp() {
        clearMocks(commonUtils)
    }

    @Test
    fun printSomething() {
        assertEquals("something has been printed hello", kotlinClassService.printSomething("hello"))
    }

    @Test
    fun dependencyInjection() {
        every { commonUtils.callMeMaybe() } returns "This is my number"

        assertEquals("This is my number", kotlinClassService.dependencyInjection())
    }
}