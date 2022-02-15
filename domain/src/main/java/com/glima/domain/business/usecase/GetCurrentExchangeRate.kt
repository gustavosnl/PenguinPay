package com.glima.domain.business.usecase

import com.glima.domain.business.model.CurrencyExchangeTable
import com.glima.domain.business.repository.CurrencyRepository

interface GetCurrentExchangeRate {
    suspend operator fun invoke(): CurrencyExchangeTable
}

class GetCurrentExchangeRateUseCase(private val repository: CurrencyRepository) :
    GetCurrentExchangeRate {
    override suspend fun invoke(): CurrencyExchangeTable {
        return repository.getCurrentExchange()
    }
}