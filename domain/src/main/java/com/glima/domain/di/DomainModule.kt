package com.glima.domain.di

import com.glima.domain.business.usecase.*
import org.koin.dsl.module

object DomainModule {
    val module = module {

        single<GetCurrentExchangeRate> { GetCurrentExchangeRateUseCase(get()) }

        single<ConvertFromBinary> { ConvertFromBinaryUseCase() }

        single<ConvertToBinary> { ConvertToBinaryUseCase() }
    }
}