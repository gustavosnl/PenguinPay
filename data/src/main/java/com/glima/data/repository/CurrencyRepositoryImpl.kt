package com.glima.data.repository

import com.glima.data.api.ExchangeRateAPI
import com.glima.data.mapper.ExchangeTableMapper
import com.glima.domain.business.model.CurrencyExchangeTable
import com.glima.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private val api: ExchangeRateAPI,
    private val mapper: ExchangeTableMapper
) : CurrencyRepository {
    override fun getCurrentExchange(): CurrencyExchangeTable {
        TODO("Not yet implemented")
    }
}