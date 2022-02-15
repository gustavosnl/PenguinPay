package com.glima.data.repository

import com.glima.data.api.ExchangeRateAPI
import com.glima.data.mapper.ExchangeTableMapper
import com.glima.domain.business.model.CurrencyExchangeTable
import com.glima.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private val api: ExchangeRateAPI,
    private val mapper: ExchangeTableMapper
) : CurrencyRepository {
    override suspend fun getCurrentExchange(): CurrencyExchangeTable {
        return api.getLatestExchangeRates("48b106a7df5d4c008f275129428a93c2").let {
            mapper.mapFrom(it)
        }
    }
}