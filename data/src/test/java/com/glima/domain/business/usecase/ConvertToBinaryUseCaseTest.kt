package com.glima.domain.business.usecase

import junit.framework.Assert.assertEquals
import org.junit.Test

internal class ConvertToBinaryUseCaseTest {
    // SUT : System Under Test
    val SUT: ConvertToBinary = ConvertToBinaryUseCase()

    @Test
    fun invoke_validPositiveInteger_returnsBinaryRepresentation() {
        val input = 42
        val output = SUT(input)

        assertEquals("101010", output)
    }

    @Test
    fun invoke_invalidNegativeInteger_returnsPositiveBinaryRepresentation() {
        val input = -42
        val output = SUT(input)

        assertEquals("101010", output)
    }
}