package com.glima.data.repository

import com.glima.data.api.ExchangeRateAPI
import com.glima.domain.business.model.CurrencyExchangeTable
import com.glima.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(private val api: ExchangeRateAPI) : CurrencyRepository {
    override fun getCurrentExchange(): CurrencyExchangeTable {
        TODO("Not yet implemented")
    }
}