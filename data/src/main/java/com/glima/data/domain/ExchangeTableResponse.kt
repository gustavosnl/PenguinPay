package com.glima.data.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
data class ExchangeTableResponse(
    val rates: RatesResponse
)
@JsonClass(generateAdapter = true)
data class RatesResponse(
    @Json(name = "KES") val kenya: Double,
    @Json(name = "NGN") val nigeria: Double,
    @Json(name = "TZS") val tanzania: Double,
    @Json(name = "UGX") val uganda: Double,
)

