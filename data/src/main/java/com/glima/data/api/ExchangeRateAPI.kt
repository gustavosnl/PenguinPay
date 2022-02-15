package com.glima.data.api

import com.glima.data.domain.ExchangeTableResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateAPI {

    @GET("latest.json")
    fun getLatestExchangeRates(@Query("app_id") appId: String) : ExchangeTableResponse
}