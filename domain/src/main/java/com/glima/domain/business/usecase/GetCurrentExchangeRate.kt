package com.glima.domain.business.usecase

import com.glima.domain.business.model.CurrencyExchangeTable

interface GetCurrentExchangeRate {
    suspend operator fun invoke(): CurrencyExchangeTable
}

class GetCurrentExchangeRateUseCase: GetCurrentExchangeRate{
    override suspend fun invoke(): CurrencyExchangeTable {
        TODO("Not yet implemented")
    }
}