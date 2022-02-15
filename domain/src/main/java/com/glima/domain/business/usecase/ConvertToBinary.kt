package com.glima.domain.business.usecase

import kotlin.math.absoluteValue

interface ConvertToBinary {
    operator fun invoke(input: Int): String
}

class ConvertToBinaryUseCase : ConvertToBinary {
    override fun invoke(input: Int): String = Integer.toBinaryString(input.absoluteValue)
}