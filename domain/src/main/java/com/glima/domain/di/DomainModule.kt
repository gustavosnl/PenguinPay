package com.glima.domain.di

import com.glima.domain.business.usecase.GetCurrentExchangeRate
import com.glima.domain.business.usecase.GetCurrentExchangeRateUseCase
import org.koin.dsl.module

object DomainModule {
    val module = module {

        single<GetCurrentExchangeRate> {
            GetCurrentExchangeRateUseCase(get())
        }
    }
}