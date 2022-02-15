package com.glima.data.domain

import com.squareup.moshi.Json
import java.math.BigDecimal

data class ExchangeTableResponse(
    val rates: RatesResponse
)

data class RatesResponse(
    @Json(name = "KES") val kenya: BigDecimal,
    @Json(name = "NGN") val nigeria: BigDecimal,
    @Json(name = "TZS") val tanzania: BigDecimal,
    @Json(name = "UGX") val uganda: BigDecimal,
)

