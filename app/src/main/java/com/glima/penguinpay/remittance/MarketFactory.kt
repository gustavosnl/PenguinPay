package com.glima.penguinpay.remittance

import com.glima.domain.business.model.Country
import com.glima.penguinpay.R

object MarketFactory {

    fun make(country: Country): MarketVO {

        return MarketVO(
            flagIcon = resolveFlag(country.currencyLabel),
            name = country.name,
            countryCode = country.phoneRule.countryCode,
            currency = country.currencyLabel,
            digits = country.phoneRule.digits
        )
    }

    private fun resolveFlag(currencyLabel: String) = when (currencyLabel) {
        "KES" -> R.drawable.ic_flag_kenya
        "NGN" -> R.drawable.ic_flag_nigeria
        "TZS" -> R.drawable.ic_flag_tanzania
        else -> R.drawable.ic_flag_uganda
    }
}