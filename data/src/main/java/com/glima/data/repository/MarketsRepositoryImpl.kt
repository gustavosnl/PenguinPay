package com.glima.data.repository

import com.glima.domain.business.model.Country
import com.glima.domain.business.model.PhoneRule
import com.glima.domain.repository.MarketsRepository

const val NINE_DIGITS_PHONE = 9
const val SEVEN_DIGITS_PHONE = 7

class MarketsRepositoryImpl : MarketsRepository {
    override fun getAvailableReceivingMarkets() = createList()

    private fun createList() = listOf(
        Country("Kenya", "KES", PhoneRule("+254", NINE_DIGITS_PHONE)),
        Country("Nigeria", "NGN", PhoneRule("+234", SEVEN_DIGITS_PHONE)),
        Country("Tanzania", "TZN", PhoneRule("+255", NINE_DIGITS_PHONE)),
        Country("Uganda", "UGN", PhoneRule("+256", SEVEN_DIGITS_PHONE)),
    )

}



