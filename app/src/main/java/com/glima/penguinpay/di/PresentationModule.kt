package com.glima.penguinpay.di

import com.glima.penguinpay.remittance.RemittanceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val module = module {

        viewModel<RemittanceViewModel> {
            RemittanceViewModel(
                convertFromBinary = get(),
                convertToBinary = get(),
                getCurrentExchangeRate = get()
            )
        }
    }
}