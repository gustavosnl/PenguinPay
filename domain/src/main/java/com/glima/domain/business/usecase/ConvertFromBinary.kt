package com.glima.domain.business.usecase

private const val INVALID_INPUT_FALLBACK = 0
private const val BINARY_RADIX = 2

interface ConvertFromBinary {
    operator fun invoke(input: String): Int
}

class ConvertFromBinaryUseCase : ConvertFromBinary {
    override fun invoke(input: String) = try {
        input.toInt(BINARY_RADIX)
    } catch (e: NumberFormatException) {
        INVALID_INPUT_FALLBACK
    }
}


