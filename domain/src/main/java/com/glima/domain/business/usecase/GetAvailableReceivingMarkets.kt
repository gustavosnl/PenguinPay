package com.glima.domain.business.usecase

import com.glima.domain.business.model.Country
import com.glima.domain.repository.MarketsRepository

interface GetAvailableReceivingMarkets {

    operator fun invoke(): List<Country>
}

class GetAvailableReceivingMarketsUseCase(private val repository: MarketsRepository) :
    GetAvailableReceivingMarkets {
    override fun invoke() = repository.getAvailableReceivingMarkets()
}
