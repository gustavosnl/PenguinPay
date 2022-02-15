package com.glima.data.mapper

import com.glima.data.domain.ExchangeTableResponse
import com.glima.domain.business.model.CurrencyExchangeTable

class ExchangeTableMapper : Mapper<ExchangeTableResponse, CurrencyExchangeTable> {

    override fun mapFrom(response: ExchangeTableResponse) = with(response.rates) {
        CurrencyExchangeTable(
            exchangeTable = mapOf(
                "KES" to kenya,
                "NGN" to nigeria,
                "TZS" to tanzania,
                "UGX" to uganda,
            )
        )
    }
}