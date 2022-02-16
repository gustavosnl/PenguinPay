package com.glima.domain.repository

import com.glima.domain.business.model.Country

interface MarketsRepository {

    fun getAvailableReceivingMarkets() : List<Country>
}