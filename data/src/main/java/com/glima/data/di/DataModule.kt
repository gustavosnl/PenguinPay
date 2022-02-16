package com.glima.data.di

import com.glima.data.mapper.ExchangeTableMapper
import com.glima.data.repository.CurrencyRepositoryImpl
import com.glima.data.repository.MarketsRepositoryImpl
import com.glima.domain.repository.CurrencyRepository
import com.glima.domain.repository.MarketsRepository
import org.koin.dsl.module

object DataModule {
    val module = module {

        single<CurrencyRepository> {
            CurrencyRepositoryImpl(get(), get())
        }

        single<MarketsRepository> {
            MarketsRepositoryImpl()
        }

        single { ExchangeTableMapper() }
    }
}