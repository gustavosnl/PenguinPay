package com.glima.domain.repository

import com.glima.domain.business.model.CurrencyExchangeTable

interface CurrencyRepository {
    fun getCurrentExchange(): CurrencyExchangeTable
}