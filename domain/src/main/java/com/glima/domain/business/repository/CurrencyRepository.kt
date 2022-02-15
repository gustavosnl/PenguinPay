package com.glima.domain.business.repository

import com.glima.domain.business.model.CurrencyExchangeTable

interface CurrencyRepository {
    fun getCurrentExchange(): CurrencyExchangeTable
}