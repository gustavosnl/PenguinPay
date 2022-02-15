package com.glima.domain.business.model


class CurrencyExchangeTable(
    private val exchangeTable: Map<String, Double>
) {
    fun getExchangeRate(currencyId: String) = exchangeTable[currencyId]?.toInt() ?: 0
}


