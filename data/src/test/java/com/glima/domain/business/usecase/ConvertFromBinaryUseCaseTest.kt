package com.glima.domain.business.usecase

import junit.framework.Assert.*
import org.junit.Test


internal class ConvertFromBinaryUseCaseTest{

    // SUT : System Under Test
    val SUT: ConvertFromBinary = ConvertFromBinaryUseCase()

    @Test
    fun invoke_validBinary_returnsIntValue() {
        val input = "101010"
        val output = SUT(input)

        assertEquals(42, output)
    }

    @Test
    fun invoke_zero_returnsIntValue() {
        val input = "0"
        val output = SUT(input)

        assertEquals(0, output)
    }

    @Test
    fun invoke_invalidInput_returnsZero() {
        val input = "A10C"
        val output = SUT(input)

        assertEquals(0, output)
    }
}