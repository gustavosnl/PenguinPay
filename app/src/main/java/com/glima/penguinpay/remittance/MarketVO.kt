package com.glima.penguinpay.remittance

import androidx.annotation.DrawableRes

data class MarketVO(
    @DrawableRes val flagIcon: Int,
    val name: String,
    val countryCode: String,
    val currency: String
)


